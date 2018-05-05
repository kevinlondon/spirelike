package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.CardCollection;
import spirelike.Enemy;
import spirelike.core.Game;
import spirelike.Player;
import spirelike.cards.Card;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

public class BattleScreen implements Screen {

    private ArrayList<Enemy> enemies;
    private Player player;
    private AsciiPanel terminal;

    private final CardCollection deck;
    private final CardCollection hand = new CardCollection();
    private final CardCollection discardPile = new CardCollection();
    private final CardCollection exhaustedPile = new CardCollection();

    private static int PLAYER_Y_OFFSET = 1;
    private static int ENEMY_START_Y_POSITION = PLAYER_Y_OFFSET + 2;
    private int MAX_Y_POSITION;

    private static int CURSOR_X_OFFSET = 1;
    private static int TEXT_X_OFFSET = CURSOR_X_OFFSET + 3;

    private int cursorPosition = 0;

    public BattleScreen(final AsciiPanel terminal) {
        enemies = new ArrayList<>();
        Enemy enemy = new Enemy("Monster", 10, 10);
        enemies.add(enemy);
        player = Game.player;
        deck = player.getDeck();
        this.terminal = terminal;

        MAX_Y_POSITION = terminal.getHeightInCharacters() - 1;

        startPlayerTurn();
    }

    @Override
    public void displayOutput() {
        this.terminal = terminal;

        if (enemies.isEmpty()) {
            terminal.write("A WINNER IS YOU", 2, 3);
            return;
        }

        renderPlayer();
        renderEnemies();
        renderHand();
        renderCursor();
    }

    private void startPlayerTurn() {
        for (int x = 0; x < player.CARD_DRAW_COUNT; x++) {
            hand.addCard(deck.drawCard());
        }
    }

    private void renderPlayer() {
        terminal.write(player.toBattleStats(), TEXT_X_OFFSET, PLAYER_Y_OFFSET);
    }

    private void renderEnemies() {
        int y = ENEMY_START_Y_POSITION;
        for (Enemy enemy : enemies) {
            terminal.write(enemy.toString(), TEXT_X_OFFSET, y);
        }
    }

    private void renderHand() {
        int y = MAX_Y_POSITION;

        for (Card card : hand.getCards()) {
            terminal.write(card.toString(), TEXT_X_OFFSET, y);
            y -= 1;
        }
    }

    private void renderCursor() {
        terminal.write('>', CURSOR_X_OFFSET, cursorPosition);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_UP:
                cursorPosition = Math.max(cursorPosition - 1, 0);
                break;

            case KeyEvent.VK_DOWN:
                cursorPosition = Math.min(cursorPosition + 1, terminal.getHeightInCharacters() - 1);
                break;

            case KeyEvent.VK_ENTER:
                playCardAtIndex(MAX_Y_POSITION - cursorPosition);
                break;
        }

        return this;
    }

    private void playCardAtIndex(final int index) {
        final Card card = hand.getCardAtIndex(index);
        if (card.needsTarget()) {
            Enemy enemy = enemies.get(0);
            card.play(enemy);
            if (enemy.isDead()) {
                enemies.remove(enemy);
            }
        }
    }
}
