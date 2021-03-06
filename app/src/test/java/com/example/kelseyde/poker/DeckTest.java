package com.example.kelseyde.poker;

import com.example.kelseyde.poker.models.Card;
import com.example.kelseyde.poker.models.CardDisplayer;
import com.example.kelseyde.poker.models.Deck;
import com.example.kelseyde.poker.models.RankType;
import com.example.kelseyde.poker.models.SuitType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deck;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before() {
        deck = new Deck();
        card1 = new Card(SuitType.SPADES, RankType.QUEEN);
        card2 = new Card(SuitType.HEARTS, RankType.EIGHT);
        card3 = new Card(SuitType.CLUBS, RankType.FIVE);

    }

    @Test
    public void testDeckStartsAt52() {
        assertEquals(52, deck.size());
    }

    @Test
    public void testCanAddCard() {
        deck.add(card1);
        assertEquals(card1, deck.getDeck().get(52));
    }

    @Test
    public void testCanRemoveCard() {
        deck.add(card1);
        assertEquals(53, deck.size());
        deck.remove(0);
        assertEquals(52, deck.size());
    }

    @Test
    public void testClearDeck() {
        deck.add(card1);
        assertEquals(53, deck.size());
        deck.clear();
        assertEquals(0, deck.size());
    }

    @Test
    public void testNewDeck() {
        deck.clear();
        deck.newDeck();
        assertEquals(52, deck.size());

    }

    @Test
    public void testShuffle() {
        Deck deck2 = new Deck();
        deck.newDeck();
        deck2.newDeck();
        deck.shuffle();
        assertFalse((deck.getDeck()).equals(deck2.getDeck()));
        assertFalse((deck.get(0)).equals(deck2.get(0)));
    }

}