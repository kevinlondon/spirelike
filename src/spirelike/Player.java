package spirelike;

public class Player {
    private final Deck deck;

    private int maxHealth;
    private int currentHealth;

    public Player(Deck deck, int maxHealth) {
        this.deck = deck;
        this.maxHealth = this.currentHealth = maxHealth;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}