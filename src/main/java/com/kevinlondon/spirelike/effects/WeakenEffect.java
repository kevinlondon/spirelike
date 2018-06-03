package com.kevinlondon.spirelike.effects;

import com.kevinlondon.spirelike.Creature;
import com.kevinlondon.spirelike.statuses.Weak;

import java.util.List;

public class WeakenEffect implements Effect {

    public int duration;

    public WeakenEffect(final int duration) {
        this.duration = duration;
    }

    @Override
    public void apply(Creature actor, List<Creature> targets) {
        for (Creature target : targets) {
            target.addStatus(new Weak(duration));
        }
    }
}
