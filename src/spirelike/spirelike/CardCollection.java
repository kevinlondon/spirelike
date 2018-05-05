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

    public Card getCardAtIndex(final int index) {
        return cards.get(index);
    }

    public void addCard(final Card card) {
        // pass
        cards.add(card);
    }

    public Card drawCard() {
        final Card card = getCard();
        cards.remove(0);
        return card;
    }
}
