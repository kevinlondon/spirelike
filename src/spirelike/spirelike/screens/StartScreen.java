package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.screens.BattleScreen;

import java.awt.event.KeyEvent;

class StartScreen implements spirelike.screens.Screen {
    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("hello", 1, 1);
    }

    @Override
    public spirelike.screens.Screen respondToUserInput(KeyEvent key) {
        if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            // initialize game
            // Create screen, which should initialize itself
            return new BattleScreen();
        } else {
            return this;
        }
    }
}