package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.Game;

import java.awt.event.KeyEvent;

public interface Screen {

    void displayOutput(AsciiPanel terminal);

    Screen respondToUserInput(KeyEvent key);
}
