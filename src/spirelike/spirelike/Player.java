package spirelike;


import lombok.Data;

import spirelike.CardCollection;
import spirelike.cards.Card;

@Data
public class Player {

    private final CardCollection deck = new CardCollection();
    private final CardCollection hand = new CardCollection();
    private final CardCollection discardPile = new CardCollection();
    private final CardCollection exhaustedPile = new CardCollection();

    private static final int STARTING_HEALTH = 30;
    private int maxHealth = STARTING_HEALTH;
    private int health;

    private static final int STARTING_MANA = 3;
    private int maxMana = STARTING_MANA;
    private int mana;


    public Player() {
        this.health = this.maxHealth;

        Card strike = new Card("Strike", 5, 0, 1);
        Card defend = new Card("Defend", 0, 5, 1);
        for (int i=0; i < 5; i++) {
            deck.addCard(strike);
            deck.addCard(defend);
        }
    }
}