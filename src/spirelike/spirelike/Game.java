package spirelike;

import asciiPanel.AsciiPanel;
import lombok.Data;
import lombok.Getter;
import spirelike.screens.Screen;
import spirelike.screens.StartScreen;

import java.awt.event.KeyEvent;

@Data
public class Game {
    @Getter
    public Player player;

    private Screen screen;
    private AsciiPanel terminal;

    public Game(AsciiPanel terminal) {
        this.player = new Player();
        this.screen = new StartScreen(this);
        this.terminal = terminal;
    }

    public void displayOutput(AsciiPanel terminal) {
        screen.displayOutput(terminal);
    }

    public void respondToUserInput(KeyEvent key) {
        screen = screen.respondToUserInput(key);
    }
}
