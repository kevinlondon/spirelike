package spirelike.screens;

import asciiPanel.AsciiPanel;
import lombok.Getter;
import spirelike.BattleDifficulty;
import spirelike.cards.Card;
import spirelike.cards.CardLibrary;
import spirelike.core.Game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class BattleWinScreen extends Screen{

    private List<Card> cardOptions;

    @Getter
    private int cardCount = 3;

    public BattleWinScreen(AsciiPanel terminal) {
        this.terminal = terminal;
    }

    @Override
    public void displayOutput() {
        int y = 1;
        for (Card card : cardOptions) {
            terminal.write("Card " + y + ": " + card.toBattleStatus(), 1, y);
            y += 1;
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }

    public void addRewards(BattleDifficulty battleDifficulty) {
        cardOptions = CardLibrary.getRandomCards(getCardCount());
    }

    private void selectReward() {
    }

    private void selectCard() {

    }
}
