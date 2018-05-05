package spirelike.core;

import asciiPanel.AsciiPanel;
import lombok.Data;
import spirelike.Player;
import spirelike.screens.Screen;
import spirelike.screens.StartScreen;

import java.awt.event.KeyEvent;

@Data
public class Game {
    public static Player player;
    private Dungeon dungeon;

    private Screen screen;
    private AsciiPanel terminal;

    public Game(AsciiPanel terminal) {
        this.player = new Player();
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
