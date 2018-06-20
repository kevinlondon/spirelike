package com.kevinlondon.spirelike.collectibles.cards;

import com.kevinlondon.spirelike.collectibles.CardType;
import com.kevinlondon.spirelike.effects.Effect;

import java.util.List;

public class Curse extends Card {
    public static final CardType cardType = CardType.CURSE;

    public Curse(final String name, final List<Effect> effects) {
        this(name, 0, effects);
    }

    public Curse(final String name, final int energyCost, final List<Effect> effects) {
        super(name, energyCost, effects);
    }
}
