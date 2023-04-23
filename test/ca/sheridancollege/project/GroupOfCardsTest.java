package ca.sheridancollege.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class GroupOfCardsTest {

    @Test
    public void testShuffle() {
        GroupOfCards deck = new GroupOfCards();
        deck.shuffle();
        assertEquals(52, deck.cardsLeft());
    }

    @Test
    public void testCardsLeft() {
        GroupOfCards deck = new GroupOfCards();
        assertEquals(52, deck.cardsLeft());
        deck.dealCard();
        assertEquals(51, deck.cardsLeft());
    }

    @Test
    public void testDealCard() {
        GroupOfCards deck = new GroupOfCards();
        Card card = deck.dealCard();
        assertEquals(51, deck.cardsLeft());
        assertNotNull(card);
    }
}
