package com.kevinlondon.spirelike.collectibles.cards;

import com.kevinlondon.spirelike.collectibles.CardType;
import com.kevinlondon.spirelike.effects.Effect;

import java.util.List;

public class Attack extends Card {
    public static final CardType cardType = CardType.ATTACK;

    public Attack(final String name, final int energyCost, final List<Effect> effects) {
        super(name, energyCost, effects);
    }

    @Override
    public boolean isAttack() {
        return true;
    }

    @Override
    public boolean needsTarget() {
        return true;
    }
}
