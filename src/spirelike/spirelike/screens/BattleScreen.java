package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.Game;
import spirelike.Player;

import java.awt.event.KeyEvent;

public class BattleScreen implements Screen {

    private Game game;

    public BattleScreen(Game game) {
        this.game = game;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        Player player = game.getPlayer();
        terminal.write("hello: " + player.getHealth(), 1, 1);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
