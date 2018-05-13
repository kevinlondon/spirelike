package spirelike.screens;

import asciiPanel.AsciiPanel;
import spirelike.BattleDifficulty;

import java.awt.event.KeyEvent;

public class BattleWinScreen extends Screen{

    public BattleWinScreen(AsciiPanel terminal) {
        this.terminal = terminal;
    }

    @Override
    public void displayOutput() {

    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }

    public void addRewards(BattleDifficulty battleDifficulty) {

    }
}
