package com.kevinlondon.spirelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class LoseScreen extends Screen {

    private AsciiPanel terminal;

    LoseScreen(AsciiPanel terminal) {
        this.terminal = terminal;
    }

    @Override
    public void displayOutput() {
        terminal.write("YOU'VE LOST PLAY AGAIN", 2, 2);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
};
