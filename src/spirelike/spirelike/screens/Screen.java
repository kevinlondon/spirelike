package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.Game;

import java.awt.event.KeyEvent;

public interface Screen {
    private Game game;

    void displayOutput(AsciiPanel terminal);

    Screen respondToUserInput(KeyEvent key);
}
