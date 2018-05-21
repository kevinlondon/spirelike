package com.kevinlondon.spirelike;


import com.kevinlondon.spirelike.cards.Card;
import com.kevinlondon.spirelike.cards.CardCollection;
import com.kevinlondon.spirelike.cards.CardType;
import lombok.Getter;

import java.util.ArrayList;

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
        Card strike = new Card("Strike", 5, 0, 1, CardType.ATTACK);
        Card defend = new Card("Defend", 0, 5, 1, CardType.SKILL);
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
        addBlock(card.getBlock());
    }

    /*
     * Target a single monster with a card.
     */
    public void playCardOnMonster(Card card, Monster monster) {
        monster.defend(card.getDamage());
    }

    /*
     * Target multiple monsters with a card.
     */
    public void playCardOnMonsters(Card card, ArrayList<Monster> monsters) {
    }
}