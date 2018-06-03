package com.kevinlondon.spirelike;

import com.kevinlondon.spirelike.cards.Card;
import com.kevinlondon.spirelike.cards.CardCollection;
import com.kevinlondon.spirelike.core.Game;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Battle {

    @Getter
    private List<Monster> monsters;

    @Getter
    private Player player;

    @Getter
    private BattleDifficulty battleDifficulty;

    @Getter
    private final CardCollection deck = new CardCollection();

    @Getter
    private final CardCollection hand = new CardCollection();

    @Getter
    private final CardCollection discarded = new CardCollection();

    @Getter
    private final CardCollection exhausted = new CardCollection();

    public Battle() {
        battleDifficulty = BattleDifficulty.NORMAL;

        initializeMonsters();
        initializePlayer();
        startPlayerTurn();
    }

    private void initializePlayer() {
        player = Game.player;
        deck.addCards(player.getDeck().getCards());
        player.resetMana();
    }

    private void initializeMonsters() {
        monsters = new ArrayList<>();
        Monster monster = new Monster("Monster", 42);
        monster.setActions();
        monsters.add(monster);
    }


    public void endPlayerTurn() {
        if (player.isDead()) {
            return;
        }

        discarded.addCards(hand.popCards());
        player.resetMana();
        startEnemyTurn();
    }

    private void startEnemyTurn() {
        for (Monster monster : monsters) {
            // monster.setBlock(0);
            monster.takeAction(player);
        }
        startPlayerTurn();
    }

    public void startPlayerTurn() {
        drawCards();
        player.setBlock(0);
        resetMonsterActions();
    }

    private void resetMonsterActions() {
        for (Monster monster : monsters) {
            monster.setNextAction();
        }
    }

    private void drawCards() {
        for (int x = 0; x < player.CARD_DRAW_COUNT; x++) {
            if (deck.size() == 0) {
                deck.addCards(discarded.popCards());
                deck.shuffle();
            }
            hand.addCard(deck.drawCard());
        }
    }

    public void playCardAtIndex(final int index) {
        if (index < 0 || index > hand.size() - 1) {
            return;
        }

        final Card card = hand.getCardAtIndex(index);

        if (card.getCost() > player.getMana()) {
            System.out.println("Can't play, too expensive.");
            return;
        }

        if (card.isAttack()) {
            if (card.needsTarget()) {
                Monster monster = monsters.get(0);
                player.playCardOnMonster(card, monster);
            } else {
                player.playCardOnMonsters(card, monsters);
            }

            List<Monster> monsterIterator = new ArrayList<>(monsters);
            for (Monster monster : monsterIterator) {
                if (monster.isDead()) {
                    monsters.remove(monster);
                }
            }
        } else {
            player.playCard(card);
        }

        player.spendMana(card.getCost());
        hand.removeCard(card);
        discarded.addCard(card);
    }

    public boolean isWin() {
        return monsters.isEmpty();
    }

    public boolean isLoss() {
        return player.isDead();
    }
}

