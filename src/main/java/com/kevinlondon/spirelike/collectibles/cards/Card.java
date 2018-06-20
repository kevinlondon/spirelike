package com.kevinlondon.spirelike.collectibles.cards;

import com.kevinlondon.spirelike.effects.Effect;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
public abstract class Card {

    protected final String name;
    @Getter
    protected final int energyCost;
    protected final List<Effect> effects;

    public String toBattleStatus() {
        return String.format("%s - %d Mana Cost", name, getEnergyCost());
    }

    public List<Effect> getEffects() {
        return effects;
    }


    public boolean isAttack() {
        return false;
    }

    public boolean needsTarget() {
        return false;
    }
}
