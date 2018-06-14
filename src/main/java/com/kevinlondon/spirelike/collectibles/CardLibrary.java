package com.kevinlondon.spirelike.collectibles;

import com.kevinlondon.spirelike.collectibles.cards.AttackCard;
import com.kevinlondon.spirelike.collectibles.cards.Card;
import com.kevinlondon.spirelike.collectibles.cards.SkillCard;
import com.kevinlondon.spirelike.effects.Effect;

import java.util.ArrayList;
import java.util.List;

/* Collection of all possible cards for a character. */
public class CardLibrary {
    private static CardCollection colorless = new CardCollection();  // Neutral
    private static CardCollection green = new CardCollection();      // The Silent
    private static CardCollection red = new CardCollection();        // Ironclad
    private static CardCollection blue = new CardCollection();       // The Defect

    public void CardCollection() { }

    public void initialize() {
        List<Effect> noEffects = new ArrayList<>();
        green.addCard(new AttackCard("Slice", 0, noEffects));
        green.addCard(new SkillCard("Deflect", 0, noEffects));

        colorless.addCard(new SkillCard("Good Instincts", 0, noEffects));
        colorless.addCard(new AttackCard("Swift Strike", 0, noEffects));
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