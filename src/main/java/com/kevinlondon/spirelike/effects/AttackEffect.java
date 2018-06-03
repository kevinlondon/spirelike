package com.kevinlondon.spirelike.effects;

import com.kevinlondon.spirelike.Creature;

import java.util.List;

public class AttackEffect implements Effect {

    private int times;
    private int amount;


    public AttackEffect(int times, int amount) {
        this.times = times;
        this.amount = amount;
    }

    @Override
    public void apply(final Creature actor, final List<Creature> targets) {
        for (Creature target : targets) {
            for (int i = 0; i < times; i++) {
                actor.attack(target, amount);
            }
        }
    }
}
