package com.kevinlondon.spirelike.effects;

import com.kevinlondon.spirelike.Creature;

import java.util.List;


public class BlockEffect implements Effect{

    private int times;
    private int amount;

    public BlockEffect(int times, int amount) {
        this.times = times;
        this.amount = amount;
    }

    @Override
    public void apply(final Creature actor, final List<Creature> targets) {
        for (Creature target : targets) {
            for (int i = 0; i < times; i++) {
                target.addBlock(amount);
            }
        }
    }
}
