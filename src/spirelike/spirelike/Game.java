package spirelike;

import asciiPanel.AsciiPanel;
import spirelike.screens.Screen;
import spirelike.screens.StartScreen;

import java.awt.event.KeyEvent;

public class Game {
    private final Player player;
    private Screen screen;
    private AsciiPanel terminal;

    public Game(AsciiPanel terminal) {
        this.player = new Player();
        this.screen = new StartScreen(this);
    }

    public void displayOutput(AsciiPanel terminal) {
        screen.displayOutput(terminal);
    }

    public void respondToUserInput(KeyEvent key) {
        screen = screen.respondToUserInput(key);
    }
}
