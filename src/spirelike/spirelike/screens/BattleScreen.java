package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.Enemy;
import spirelike.Game;
import spirelike.Player;
import spirelike.cards.Card;

import java.awt.event.KeyEvent;

public class BattleScreen implements Screen {

    private Game game;
    private int cursor = 0;

    private Enemy enemy;

    public BattleScreen(Game game) {
        this.game = game;
        this.enemy = new Enemy("Test Enemy", 50, 5);
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        Player player = game.getPlayer();
        int x = 5;
        int y = 1;

        terminal.write(enemy.toString(), x, y);
        y += 2;

        for (Card card : player.getDeck().getCards()) {
            terminal.write(card.toString(), x, y);
            y += 1;
        }

    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
