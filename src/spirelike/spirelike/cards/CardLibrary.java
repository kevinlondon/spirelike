package spirelike.cards;

/* Collection of all possible cards for a character. */
public class CardLibrary {
    private CardCollection colorless = new CardCollection();  // Neutral
    private CardCollection green = new CardCollection();      // The Silent
    private CardCollection red = new CardCollection();        // Ironclad
    private CardCollection blue = new CardCollection();       // The Defect

    public void CardCollection() {
        initialize();
    }

    private void initialize() {
        green.addCard(new Card("Slice", 5, 0, 0, CardType.ATTACK));
        green.addCard(new Card("Deflect", 0, 4, 0, CardType.SKILL));


        colorless.addCard(new Card("Good Instincts", 0, 4, 0, CardType.SKILL));
        colorless.addCard(new Card("Swift Strike", 5, 0, 0, CardType.ATTACK));
    }

    private void getRandomCards() {

    }
}