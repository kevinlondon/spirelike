package spirelike.cards;

import lombok.ToString;
import spirelike.Enemy;

@ToString
public class Card {
    private final String name;

    private final int baseDamage;
    private final int baseBlock;
    private final int baseCost;

    public Card(String name, int baseDamage, int baseBlock, int baseCost) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.baseBlock = baseBlock;
        this.baseCost = baseCost;
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

    public void play(Enemy enemy) {
        enemy.reduceHealth(this.getDamage());
    }

    public String toBattleStatus() {
        return this.name + " - Mana Cost: " + this.getCost() + ", Damage: " + this.getDamage() + ", Block: " + this.getBlock();
    }
}
