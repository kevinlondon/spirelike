package com.kevinlondon.spirelike.effects;

import com.kevinlondon.spirelike.Creature;

import java.util.List;

public interface Effect {

    void apply(final Creature actor, final List<Creature> targets);

}
