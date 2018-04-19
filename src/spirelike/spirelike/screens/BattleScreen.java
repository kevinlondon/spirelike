package spirelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class BattleScreen implements Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("hello", 1, 1);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
