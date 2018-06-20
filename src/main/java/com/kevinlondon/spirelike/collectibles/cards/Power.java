package com.kevinlondon.spirelike.collectibles.cards;

import com.kevinlondon.spirelike.collectibles.CardType;
import com.kevinlondon.spirelike.effects.Effect;

import java.util.List;

public class Power extends Card {
    public static final CardType cardType = CardType.POWER;

    public Power(final String name, final int energyCost, final List<Effect> effects) {
        super(name, energyCost, effects);
    }
}