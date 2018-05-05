package spirelike;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Enemy {

    @Getter
    @Setter
    private int maxHealth;

    @Getter
    @Setter
    private int health;

    @Getter
    private String name;

    public Enemy(String name, int maxHealth, int health) {
        this.maxHealth = maxHealth;
        this.health = health;
        this.name = name;
    }

    public void reduceHealth(final int amount) {
        this.health -= amount;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
