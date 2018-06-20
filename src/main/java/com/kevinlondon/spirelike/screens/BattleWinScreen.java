package com.kevinlondon.spirelike.screens;

import asciiPanel.AsciiPanel;
import com.kevinlondon.spirelike.BattleDifficulty;
import com.kevinlondon.spirelike.collectibles.CardLibrary;
import com.kevinlondon.spirelike.collectibles.cards.Card;
import lombok.Getter;

import java.awt.event.KeyEvent;
import java.util.List;

public class BattleWinScreen extends Screen {

    @Getter
    private final int cardCount = 3;
    private List<Card> cardOptions;

    public BattleWinScreen(final AsciiPanel terminal) {
        this.terminal = terminal;
    }

    @Override
    public void displayOutput() {
        int y = 1;
        for (final Card card : cardOptions) {
            terminal.write("Card " + y + ": " + card.toBattleStatus(), 1, y);
            y += 1;
        }
    }

    @Override
    public Screen respondToUserInput(final KeyEvent key) {
        return null;
    }

    public void addRewards(final BattleDifficulty battleDifficulty) {
        cardOptions = CardLibrary.getRandomCards(getCardCount());
    }

    private void selectReward() {
    }

    private void selectCard() {

    }
}
