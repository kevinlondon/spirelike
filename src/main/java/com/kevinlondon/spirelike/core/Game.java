package com.kevinlondon.spirelike.core;

import asciiPanel.AsciiPanel;
import lombok.Data;
import com.kevinlondon.spirelike.Player;
import com.kevinlondon.spirelike.collectibles.CardLibrary;
import com.kevinlondon.spirelike.screens.Screen;
import com.kevinlondon.spirelike.screens.StartScreen;

import java.awt.event.KeyEvent;

@Data
public class Game {
    public static Player player;
    public static CardLibrary cardLibrary;
    private Dungeon dungeon;

    private Screen screen;
    private AsciiPanel terminal;

    public Game(AsciiPanel terminal) {
        player = new Player("Tester", 50);
        player.initialize();

        cardLibrary = new CardLibrary();
        cardLibrary.initialize();
        this.terminal = terminal;
        this.screen = new StartScreen(terminal);
    }

    public void displayOutput(AsciiPanel terminal) {
        terminal.write(player.toStatusLine(), 0, 0);
        screen.displayOutput();
    }

    public void respondToUserInput(KeyEvent key) {
        screen = screen.respondToUserInput(key);
    }
}
