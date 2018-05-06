package spirelike;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Enemy {

    private int maxHealth;

    @Getter
    @Setter
    private int health;

    private int baseDamage;

    @Getter
    private String name;

    public Enemy(String name, int maxHealth, int damage) {
        this.maxHealth = this.health = maxHealth;
        this.name = name;
        this.baseDamage = damage;
    }

    public void reduceHealth(final int amount) {
        this.health -= amount;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public String toBattleStatus() {
        return this.name + ": " + health + "/" + maxHealth;
    }

    public void attack(Player player) {
        player.reduceHealth(this.getDamage());
    }

    private int getDamage() {
        return this.baseDamage;
    }
}
