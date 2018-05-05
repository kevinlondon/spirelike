package spirelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public interface Screen {

    void displayOutput();

    Screen respondToUserInput(KeyEvent key);
}
