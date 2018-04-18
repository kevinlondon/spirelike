package spirelike;

import spirelike.cards.Card;

import java.util.List;


@Data
public class Deck {
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }
}
