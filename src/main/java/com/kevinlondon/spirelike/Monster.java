package com.kevinlondon.spirelike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monster extends Creature {

    private List<MonsterAction> actions;
    private MonsterAction nextAction;

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    public void setActions() {
        actions = new ArrayList<>();
        actions.add(new MonsterAction(1, 10, MonsterActionType.ATTACK));
        actions.add(new MonsterAction(2, 4, MonsterActionType.ATTACK));
        actions.add(new MonsterAction(1, 6, MonsterActionType.BLOCK));
    }

    public String toBattleStatus() {
        return this.name + ": " + health + "/" + maxHealth + ", Next Action: " + nextAction.toString();
    }

    public void setNextAction() {
        Collections.shuffle(actions);
        nextAction = actions.get(0);
    }

    public void takeAction(Creature creature) {
        nextAction.apply(creature);
    }
}
