package spirelike;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Monster extends Creature {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
        baseDamage = 5;  // for testing purposes
    }

    public String toBattleStatus() {
        return this.name + ": " + health + "/" + maxHealth;
    }

    public void attack(Creature creature) {
        creature.defend(this.getDamage());
    }
}
