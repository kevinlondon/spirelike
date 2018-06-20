package com.kevinlondon.spirelike;


import com.kevinlondon.spirelike.collectibles.cards.Attack;
import com.kevinlondon.spirelike.collectibles.cards.Card;
import com.kevinlondon.spirelike.collectibles.CardCollection;
import com.kevinlondon.spirelike.collectibles.cards.Skill;
import com.kevinlondon.spirelike.effects.Effect;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {

    private static final int STARTING_MANA = 3;
    @Getter
    private final CardCollection deck = new CardCollection();
    public int CARD_DRAW_COUNT = 5;
    private int maxMana = STARTING_MANA;
    private int gold = 99;
    @Getter
    private int mana;

    public Player(String name, int maxHealth) {
        super(name, maxHealth);
        initialize();
    }

    public void initialize() {
        createDeck();
    }

    private void createDeck() {
        deck.clear();
        Card strike = new Attack("Strike", 1, new ArrayList<Effect>());
        Card defend = new Skill("Defend", 1, new ArrayList<Effect>());
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