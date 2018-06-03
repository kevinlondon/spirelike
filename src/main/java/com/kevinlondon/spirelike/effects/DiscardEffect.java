package com.kevinlondon.spirelike.effects;

import com.kevinlondon.spirelike.Creature;
import com.kevinlondon.spirelike.core.Game;

import java.util.List;

public class DiscardEffect implements Effect {

    @Override
    public void apply(Creature actor, List<Creature> targets) {
        Game.player.discardCard();
    }
}
