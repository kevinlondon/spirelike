package spirelike.core;

import asciiPanel.AsciiPanel;
import lombok.Data;
import spirelike.Player;
import spirelike.cards.CardCollection;
import spirelike.cards.CardLibrary;
import spirelike.screens.Screen;
import spirelike.screens.StartScreen;

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
