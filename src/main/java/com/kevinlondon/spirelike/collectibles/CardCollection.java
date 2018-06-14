package com.kevinlondon.spirelike.collectibles;

import com.kevinlondon.spirelike.collectibles.cards.Card;
import lombok.Data;

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

    public int size() {
        return cards.size();
    }

    public void removeCard(final Card card) {
        this.cards.remove(card);
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public List<Card> popCards() {
        List<Card> cardCopies = getCards();
        clear();
        return cardCopies;
    }

    public List<Card> getCards() {
        List<Card> cardCopy = new ArrayList<>();
        cardCopy.addAll(cards);
        return cardCopy;
    }

    public void clear() {
        cards.clear();
    }
}
