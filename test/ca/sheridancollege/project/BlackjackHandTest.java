package ca.sheridancollege.project;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BlackjackHandTest {

    @Test
    public void testGetBlackjackValue_NoAce() {
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(7, Card.SPADES));
        hand.addCard(new Card(10, Card.CLUBS));
        int expected = 17;
        int actual = hand.getBlackjackValue();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBlackjackValue_WithAce() {
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(1, Card.HEARTS));
        hand.addCard(new Card(9, Card.DIAMONDS));
        int expected = 20;
        int actual = hand.getBlackjackValue();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetBlackjackValue_AceAs11() {
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(new Card(1, Card.SPADES));
        hand.addCard(new Card(6, Card.HEARTS));
        int expected = 17;
        int actual = hand.getBlackjackValue();
        assertEquals(expected, actual);
    }
}
