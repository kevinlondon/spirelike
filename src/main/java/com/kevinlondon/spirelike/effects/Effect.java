package com.kevinlondon.spirelike.effects;

import com.google.common.collect.ImmutableList;
import com.kevinlondon.spirelike.Creature;

import java.util.List;

public interface Effect {

    void apply(final Creature actor, final List<Creature> targets);

    default void apply(final Creature actor, final Creature target) {
        apply(actor, ImmutableList.of(target));
    }
}
