package com.kevinlondon.spirelike.collectibles.cards;

import com.kevinlondon.spirelike.MonsterActionType;
import com.kevinlondon.spirelike.collectibles.CardType;
import com.kevinlondon.spirelike.effects.Effect;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

public class AttackCard extends Card {
    public static final CardType cardType = CardType.ATTACK;

    public AttackCard(String name, int energyCost, List<Effect> effects) {
        super(name, energyCost, effects);
    }

    public boolean isAttack() {
        return true;
    }

    public boolean needsTarget() {
        return true;
    }
}
