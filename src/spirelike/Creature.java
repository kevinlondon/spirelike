package spirelike;

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

    public boolean isDead() {
        return this.health <= 0;
    }


    public void defend(final int damage) {
        int remainingDamage = damage;

        if (remainingDamage <= block) {
            block -= damage;
            remainingDamage = 0;
        } else {
            remainingDamage -= block;
            block = 0;
        }

        this.health -= remainingDamage;
    }

}
