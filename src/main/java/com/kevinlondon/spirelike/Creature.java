package com.kevinlondon.spirelike;

import com.kevinlondon.spirelike.statuses.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@ToString
public abstract class Creature {
    @Getter
    protected String name;

    @Getter
    @Setter
    protected int health;

    @Getter
    @Setter
    protected int maxHealth;

    @Getter
    @Setter
    protected int strength = 0;

    @Getter
    @Setter
    protected int block = 0;

    protected List<Status> statuses;

    public Creature(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = this.health = maxHealth;
    }

    public void addBlock(int amount) {
        this.block += amount;
    }

    public void addStatus(Status status) {
        this.statuses.add(status);
    }

    public boolean isDead() {
        return this.health <= 0;
    }


    public void defend(final int damage) {
        String event = "";
        int remainingDamage = damage;

        if (remainingDamage <= block) {
            event += String.format("%s blocked %d damage. ", name, block-damage);
            block -= damage;
            remainingDamage = 0;
        } else {
            if (block > 0) {
                event += String.format("%s blocked %d damage. ", name, damage - block);
            }
            remainingDamage -= block;
            block = 0;
        }

        this.health -= remainingDamage;
        event += String.format("%s took %d damage.", name, remainingDamage);
        EventLog.add(event);
    }

    public void attack(Creature target, int amount) {
        target.defend(amount);
    }

}
