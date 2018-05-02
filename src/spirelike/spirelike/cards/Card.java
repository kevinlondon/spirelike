package spirelike.cards;

import lombok.ToString;

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
}
