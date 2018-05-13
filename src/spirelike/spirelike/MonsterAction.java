package spirelike;

public class MonsterAction {

    public MonsterAction(int numberTimes, int amount, MonsterActionType type) {
        this.numberTimes = numberTimes;
        this.amount = amount;
        this.type = type;
    }

    private int numberTimes;
    private int amount;
    private MonsterActionType type;

    public void apply(Creature creature) {
        for (int i = 0; i < numberTimes; i++) {
            if (type == MonsterActionType.ATTACK) {
                creature.defend(amount);
            } else {
                creature.addBlock(amount);
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Ignoring for now.");
            }
        }
    }


    public String toString() {
        String description = "";
        if (type == MonsterActionType.ATTACK) {
            description = "Attack";
        } else if (type == MonsterActionType.BLOCK) {
            description = "Block";
        }

        return description + " for " + amount + "x" + numberTimes;
    }
}
