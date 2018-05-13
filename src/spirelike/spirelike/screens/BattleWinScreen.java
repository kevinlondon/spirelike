package spirelike.screens;

import asciiPanel.AsciiPanel;
import lombok.Getter;
import spirelike.BattleDifficulty;
import spirelike.cards.Card;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BattleWinScreen extends Screen{

    @Getter
    private int cardCount = 3;

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
        List<Card> options = new ArrayList<>();
        for (int i = 0; i < getCardCount(); i++) {

        }
    }
}
