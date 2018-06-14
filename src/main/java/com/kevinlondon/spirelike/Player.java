package com.kevinlondon.spirelike;


import com.kevinlondon.spirelike.collectibles.cards.AttackCard;
import com.kevinlondon.spirelike.collectibles.cards.Card;
import com.kevinlondon.spirelike.collectibles.CardCollection;
import com.kevinlondon.spirelike.collectibles.CardType;
import com.kevinlondon.spirelike.collectibles.cards.SkillCard;
import com.kevinlondon.spirelike.effects.Effect;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {

    @Getter
    private final CardCollection deck = new CardCollection();

    private static final int STARTING_MANA = 3;
    private int maxMana = STARTING_MANA;
    private int gold = 99;

    @Getter
    private int mana;
    public int CARD_DRAW_COUNT = 5;

    public Player(String name, int maxHealth) {
        super(name, maxHealth);
        initialize();
    }

    public void initialize() {
        createDeck();
    }

    private void createDeck() {
        deck.clear();
        Card strike = new AttackCard("Strike", 1, new ArrayList<Effect>());
        Card defend = new SkillCard("Defend", 1, new ArrayList<Effect>());
        for (int i=0; i < 5; i++) {
            deck.addCard(strike);
            deck.addCard(defend);
        }
    }

    public String toStatusLine() {
        return "Health: " + health + "/" + maxHealth +
                ", Gold: " + gold +
                ", Deck Size: " + deck.size();
    }

    public String toBattleStats() {
        return "Player " + name +
                ", Health: " + health + "/" + maxHealth +
                ", Block: " + block;
    }

    public void resetMana() {
        mana = maxMana;
    }

    public void spendMana(final int usedMana) {
        mana -= usedMana;
    }

    /*
     * Play an untargetted card, such as a power or skill.
     */
    public void playCard(Card card) {
        for (Effect effect : card.getEffects()) {
            effect.apply(this, this);
        }
    }

    /*
     * Target a single monster with a card.
     */
    public void playCardOnMonster(Card card, Monster monster) {
        for (Effect effect : card.getEffects()) {
            effect.apply(this, monster);
        }
    }

    /*
     * Target multiple monsters with a card.
     */
    public void playCardOnMonsters(Card card, List<Monster> monsters) {
    }

    public void discardCard() {
        System.out.println("Do nothing for now.");
    }
}