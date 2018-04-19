package spirelike;


import lombok.Data;

import spirelike.CardCollection;

@Data
public class Player {

    private final CardCollection deck;
    private final CardCollection hand;
    private final CardCollection discardPile;
    private final CardCollection exhaustedPile;

    private int maxHealth;
    private int health;

    private static final int STARTING_MANA = 3;

    private int maxMana = STARTING_MANA;
    private int mana;


    public Player(int maxHealth) {
        this.maxHealth = this.health = maxHealth;
    }
}