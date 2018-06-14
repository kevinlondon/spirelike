package com.kevinlondon.spirelike.collectibles.cards;

import com.kevinlondon.spirelike.collectibles.CardType;
import com.kevinlondon.spirelike.effects.Effect;

import java.util.List;

public class SkillCard extends Card{
    public static final CardType cardType = CardType.SKILL;

    public SkillCard(String name, int energyCost, List<Effect> effects) {
        super(name, energyCost, effects);
    }
}
