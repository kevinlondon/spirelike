package com.kevinlondon.spirelike.effects;

import com.kevinlondon.spirelike.Creature;
import com.kevinlondon.spirelike.statuses.Status;
import com.kevinlondon.spirelike.statuses.StatusType;
import com.kevinlondon.spirelike.statuses.Weak;

import java.util.List;

public class StatusEffect implements Effect {

    public int duration;
    public StatusType statusType;

    public StatusEffect(final int duration) {
        this.duration = duration;
    }

    @Override
    public void apply(Creature actor, List<Creature> targets) {
        for (Creature target : targets) {
            target.addStatus(new Status(statusType, duration));
        }
    }
}
