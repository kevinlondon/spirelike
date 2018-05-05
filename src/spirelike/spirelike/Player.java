package spirelike;


import lombok.Data;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import spirelike.CardCollection;
import spirelike.cards.Card;

@Data
public class Player {

    private final CardCollection deck = new CardCollection();

    private static final int STARTING_HEALTH = 30;

    @Getter
    @Setter
    private int maxHealth = STARTING_HEALTH;

    @Getter
    @Setter private int health;

    private static final int STARTING_MANA = 3;
    private int maxMana = STARTING_MANA;
    private int mana;
    public int CARD_DRAW_COUNT = 5;


    public Player() {
        this.health = this.maxHealth;

        Card strike = new Card("Strike", 5, 0, 1);
        Card defend = new Card("Defend", 0, 5, 1);
        for (int i=0; i < 5; i++) {
            deck.addCard(strike);
            deck.addCard(defend);
        }
    }

    public String toStatusLine() {
        return "Player Goes Here";
    }

    public String toBattleStats() {
        return "Health: " + health + " / " + maxHealth + ", Mana: " + mana + " / " + maxMana;
    }
}