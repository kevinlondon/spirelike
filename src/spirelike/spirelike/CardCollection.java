package spirelike;

import lombok.Data;
import spirelike.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Data
public class CardCollection {
    private List<Card> cards;

    public CardCollection() {
        this.cards = new ArrayList<Card>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard() {
        // pass
        return cards.get(0);
    }

    public void addCard(final Card card) {
        // pass
        return;
    }
}
