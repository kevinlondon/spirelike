package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.cards.CardCollection;
import spirelike.Monster;
import spirelike.core.Game;
import spirelike.Player;
import spirelike.cards.Card;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class BattleScreen implements Screen {

    private ArrayList<Monster> monsters;
    private Player player;
    private AsciiPanel terminal;

    private final CardCollection deck = new CardCollection();
    private final CardCollection hand = new CardCollection();
    private final CardCollection discarded = new CardCollection();
    private final CardCollection exhausted = new CardCollection();

    private static int MAX_HAND_CARDS = 9;
    private static int PLAYER_Y_OFFSET = 1;
    private static int ENEMY_START_Y_POSITION = PLAYER_Y_OFFSET + 2;

    private static int CURSOR_X_OFFSET = 1;
    private static int TEXT_X_OFFSET = CURSOR_X_OFFSET + 3;
    private static int CARD_START_Y_POSITION = 12;  // max height of 23 at the moment, max cards of 9.

    private static int DECK_SIZE_OFFSET = CARD_START_Y_POSITION + MAX_HAND_CARDS + 1;
    private static int HELP_OFFSET = DECK_SIZE_OFFSET + 1;

    private int cursorPosition = PLAYER_Y_OFFSET;  // default to selecting where the player is

    public BattleScreen(final AsciiPanel terminal) {
        initializeMonsters();
        initializePlayer();
        this.terminal = terminal;
        startPlayerTurn();
    }

    private void initializePlayer() {
        player = Game.player;
        deck.addCards(player.getDeck().getCards());
        player.resetMana();
    }

    private void initializeMonsters() {
        monsters = new ArrayList<>();
        Monster monster = new Monster("Monster", 42);
        monster.setActions();
        monsters.add(monster);
    }

    @Override
    public void displayOutput() {
        this.terminal = terminal;

        if (monsters.isEmpty()) {
            terminal.write("A WINNER IS YOU", 2, 3);
            return;
        }

        if (player.isDead()) {
            terminal.write("YOU'VE LOST PLAY AGAIN", 2, 2);
        }

        renderPlayer();
        renderEnemies();
        renderHand();
        renderDeckSizes();
        renderCursor();
        renderHelp();
    }

    private void renderHelp() {
        terminal.write("Press [e] to end your turn or the card number to play it.", TEXT_X_OFFSET, HELP_OFFSET);
    }

    private void startPlayerTurn() {
        drawCards();
        resetBlock();
        resetMonsterActions();
    }

    private void resetMonsterActions() {
        for (Monster monster : monsters) {
            monster.setNextAction();
        }
    }

    private void drawCards() {
        for (int x = 0; x < player.CARD_DRAW_COUNT; x++) {
            if (deck.size() == 0) {
                deck.addCards(discarded.popCards());
                deck.shuffle();
            }
            hand.addCard(deck.drawCard());
        }
    }

    private void resetBlock() {
        player.setBlock(0);
        for (Monster monster : monsters) {
            monster.setBlock(0);
        }
    }

    private void renderPlayer() {
        terminal.write(player.toBattleStats(), TEXT_X_OFFSET, PLAYER_Y_OFFSET);
    }

    private void renderEnemies() {
        int y = ENEMY_START_Y_POSITION;
        for (Monster monster : monsters) {
            terminal.write(monster.toBattleStatus(), TEXT_X_OFFSET, y);
        }
    }

    private void renderHand() {
        int count = 1;

        for (Card card : hand.getCards()) {
            terminal.write(count + ": " + card.toBattleStatus(), TEXT_X_OFFSET, CARD_START_Y_POSITION + count);
            count += 1;
        }

    }

    private void renderDeckSizes() {
        final String deckSizes = "Draw Pile: " + deck.size() + ", Discarded: " + discarded.size() + ", Exhausted: " + exhausted.size();
        terminal.write(deckSizes, TEXT_X_OFFSET, DECK_SIZE_OFFSET);
    }

    private void renderCursor() {
        terminal.write('>', CURSOR_X_OFFSET, cursorPosition);
    }

    private void endPlayerTurn() {
        if (player.isDead()) {
            return;
        }

        discarded.addCards(hand.popCards());

        player.resetMana();
        startEnemyTurn();
    }

    private void startEnemyTurn() {
        for (Monster monster : monsters) {
            monster.takeAction(player);
        }
        startPlayerTurn();
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        final int selectedIndex;

        switch (key.getKeyCode()){
            case KeyEvent.VK_UP:
                cursorPosition = Math.max(cursorPosition - 1, 0);
                break;

            case KeyEvent.VK_DOWN:
                cursorPosition = Math.min(cursorPosition + 1, terminal.getHeightInCharacters() - 1);
                break;

            case KeyEvent.VK_ENTER:
                playCardAtIndex(cursorPosition - CARD_START_Y_POSITION);
                break;
            case KeyEvent.VK_1:
                // TODO: Make a key map for this when I have internet
                playCardAtIndex(0);
                break;
            case KeyEvent.VK_2:
                playCardAtIndex(1);
                break;
            case KeyEvent.VK_3:
                playCardAtIndex(2);
                break;
            case KeyEvent.VK_4:
                playCardAtIndex(3);
                break;
            case KeyEvent.VK_5:
                playCardAtIndex(4);
                break;
            case KeyEvent.VK_6:
                playCardAtIndex(5);
                break;
            case KeyEvent.VK_7:
                playCardAtIndex(6);
                break;
            case KeyEvent.VK_8:
                playCardAtIndex(7);
                break;
            case KeyEvent.VK_9:
                playCardAtIndex(8);
                break;

            case KeyEvent.VK_E:
                endPlayerTurn();
                break;
        }

        return this;
    }

    private void playCardAtIndex(final int index) {
        if (index < 0 || index > hand.size() - 1) {
            return;
        }

        final Card card = hand.getCardAtIndex(index);

        if (card.getCost() > player.getMana()) {
            System.out.println("Can't play, too expensive.");
            return;
        }

        if (card.isAttack()) {
            if (card.needsTarget()) {
                Monster monster = monsters.get(0);
                player.playCardOnMonster(card, monster);
            } else {
                player.playCardOnMonsters(card, monsters);
            }

            for (Monster monster : monsters) {
                if (monster.isDead()) {
                    monsters.remove(monster);
                }
            }
        } else {
            player.playCard(card);
        }

        player.spendMana(card.getCost());
        hand.removeCard(card);
        discarded.addCard(card);
    }
}
