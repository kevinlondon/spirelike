package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.Game;
import spirelike.screens.BattleScreen;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    private Game game;

    public StartScreen(Game game) {
        this.game = game;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("test", 1, 1);
    }

    @Override
    public spirelike.screens.Screen respondToUserInput(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            // initialize game
            // Create screen, which should initialize itself
            return new BattleScreen(game);
        } else {
            return this;
        }
    }
}