package com.kevinlondon.spirelike.cards;

import com.kevinlondon.spirelike.core.Game;
import lombok.ToString;

@ToString
public class Card {
    private final String name;

    private final int baseDamage;
    private final int baseBlock;
    private final int baseCost;
    private final CardType type;

    public Card(String name, int baseDamage, int baseBlock, int baseCost, CardType type) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.baseBlock = baseBlock;
        this.baseCost = baseCost;
        this.type = type;
    }

    public boolean needsTarget() {
        return true;
    }

    public int getDamage() {
        return this.baseDamage;
    }

    public int getCost() {
        return this.baseCost;
    }

    public int getBlock() {
        return this.baseBlock;
    }

    public String toBattleStatus() {
        return this.name + " - Mana Cost: " + this.getCost() + ", Damage: " + this.getDamage() + ", Block: " + this.getBlock();
    }

    public void play() {
        Game.player.addBlock(this.getBlock());
    }

    public boolean isAttack() {
        return type == CardType.ATTACK;
    }
}
