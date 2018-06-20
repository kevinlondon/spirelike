package com.kevinlondon.spirelike.screens;

import asciiPanel.AsciiPanel;
import com.kevinlondon.spirelike.Battle;
import com.kevinlondon.spirelike.EventLog;
import com.kevinlondon.spirelike.Monster;
import com.kevinlondon.spirelike.collectibles.cards.Card;
import com.kevinlondon.spirelike.renderers.Renderer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BattleScreen extends Screen {

    private static final int MAX_HAND_CARDS = 9;
    private static final int PLAYER_Y_OFFSET = 1;
    private static final int ENEMY_START_Y_POSITION = PLAYER_Y_OFFSET + 2;
    private static final int CURSOR_X_OFFSET = 1;
    private static final int TEXT_X_OFFSET = CURSOR_X_OFFSET + 3;
    private static final int CARD_START_Y_POSITION = 12;  // max height of 23 at the moment, max cards of 9.
    private static final int DECK_SIZE_OFFSET = CARD_START_Y_POSITION + MAX_HAND_CARDS + 1;
    private static final int HELP_OFFSET = DECK_SIZE_OFFSET + 1;
    private final AsciiPanel terminal;
    private final Battle battle;
    private final List<Renderer> renderers;
    private int cursorPosition = PLAYER_Y_OFFSET;  // default to selecting where the player is

    public BattleScreen(final AsciiPanel terminal) {
        this.terminal = terminal;
        this.battle = new Battle();
        this.renderers = new ArrayList<>();
    }

    @Override
    public void displayOutput() {
        for (final Renderer renderer : renderers) {
            renderer.render(terminal);
        }

        renderPlayer();
        renderEnemies();
        renderHand();
        renderDeckSizes();
        renderCursor();
        renderHelp();

        EventLog.render(terminal, 27);
    }

    private void renderHelp() {
        terminal.write("Press [e] to end your turn or the card number to play it.", TEXT_X_OFFSET, HELP_OFFSET);
    }

    private void renderPlayer() {
        terminal.write(battle.getPlayer().toBattleStats(), TEXT_X_OFFSET, PLAYER_Y_OFFSET);
    }

    private void renderEnemies() {
        final int y = ENEMY_START_Y_POSITION;
        for (final Monster monster : battle.getMonsters()) {
            terminal.write(monster.toBattleStatus(), TEXT_X_OFFSET, y);
        }
    }

    private void renderHand() {
        int count = 1;

        for (final Card card : battle.getHand().getCards()) {
            terminal.write(count + ": " + card.toBattleStatus(), TEXT_X_OFFSET, CARD_START_Y_POSITION + count);
            count += 1;
        }

    }

    private void renderDeckSizes() {
        final String deckSizes = "Draw Pile: " + battle.getDeck().size() +
                ", Discarded: " + battle.getDiscarded().size() +
                ", Exhausted: " + battle.getExhausted().size();
        terminal.write(deckSizes, TEXT_X_OFFSET, DECK_SIZE_OFFSET);
    }

    private void renderCursor() {
        terminal.write('>', CURSOR_X_OFFSET, cursorPosition);
    }


    @Override
    public Screen respondToUserInput(final KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                cursorPosition = Math.max(cursorPosition - 1, 0);
                break;

            case KeyEvent.VK_DOWN:
                cursorPosition = Math.min(cursorPosition + 1, terminal.getHeightInCharacters() - 1);
                break;

            case KeyEvent.VK_ENTER:
                battle.playCardAtIndex(cursorPosition - CARD_START_Y_POSITION);
                break;
            case KeyEvent.VK_1:
                // TODO: Make a key map for this when I have internet
                battle.playCardAtIndex(0);
                break;
            case KeyEvent.VK_2:
                battle.playCardAtIndex(1);
                break;
            case KeyEvent.VK_3:
                battle.playCardAtIndex(2);
                break;
            case KeyEvent.VK_4:
                battle.playCardAtIndex(3);
                break;
            case KeyEvent.VK_5:
                battle.playCardAtIndex(4);
                break;
            case KeyEvent.VK_6:
                battle.playCardAtIndex(5);
                break;
            case KeyEvent.VK_7:
                battle.playCardAtIndex(6);
                break;
            case KeyEvent.VK_8:
                battle.playCardAtIndex(7);
                break;
            case KeyEvent.VK_9:
                battle.playCardAtIndex(8);
                break;

            case KeyEvent.VK_E:
                battle.endPlayerTurn();
                break;
        }

        return getNextScreen();
    }

    private Screen getNextScreen() {
        if (battle.isWin()) {
            final BattleWinScreen screen = new BattleWinScreen(terminal);
            screen.addRewards(battle.getBattleDifficulty());
            return screen;
        } else if (battle.isLoss()) {
            return new LoseScreen(terminal);
        } else {
            return this;
        }
    }
}
