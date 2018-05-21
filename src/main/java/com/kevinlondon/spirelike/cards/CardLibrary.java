package com.kevinlondon.spirelike.cards;

import java.util.List;

/* Collection of all possible cards for a character. */
public class CardLibrary {
    private static CardCollection colorless = new CardCollection();  // Neutral
    private static CardCollection green = new CardCollection();      // The Silent
    private static CardCollection red = new CardCollection();        // Ironclad
    private static CardCollection blue = new CardCollection();       // The Defect

    public void CardCollection() { }

    public void initialize() {
        green.addCard(new Card("Slice", 5, 0, 0, CardType.ATTACK));
        green.addCard(new Card("Deflect", 0, 4, 0, CardType.SKILL));

        colorless.addCard(new Card("Good Instincts", 0, 4, 0, CardType.SKILL));
        colorless.addCard(new Card("Swift Strike", 5, 0, 0, CardType.ATTACK));
    }

    public static List<Card> getRandomCards(int cardCount) {
        CardCollection available = new CardCollection();
        available.addCards(green.getCards());
        available.addCards(colorless.getCards());

        available.shuffle();
        List<Card> cards = available.popCards();

        return cards.subList(0, cardCount);
    }
}