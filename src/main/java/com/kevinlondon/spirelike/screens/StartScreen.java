package com.kevinlondon.spirelike.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen extends Screen {


    public StartScreen(final AsciiPanel terminal) {
        this.terminal = terminal;
    }

    @Override
    public void displayOutput() {
        terminal.write("test", 1, 1);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            // initialize game
            // Create screen, which should initialize itself
            return new BattleScreen(terminal);
        } else {
            return this;
        }
    }
}