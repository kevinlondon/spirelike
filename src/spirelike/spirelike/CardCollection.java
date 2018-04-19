package spirelike;

import lombok.Data;
import spirelike.cards.Card;

import java.util.Collections;
import java.util.List;


@Data
public class CardCollection {
    private List<Card> cards;

    public CardCollection() {
        this.cards = new List<Card>[];
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard() {
        // pass
    }

    public void addCard(final Card card) {
        // pass
    }
}
