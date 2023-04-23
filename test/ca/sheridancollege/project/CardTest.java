package ca.sheridancollege.project;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    
    @Test
    public void testGetSuit() {
        Card card = new Card(1, Card.SPADES);
        assertEquals(Card.SPADES, card.getSuit());
    }
    
    @Test
    public void testGetValue() {
        Card card = new Card(11, Card.CLUBS);
        assertEquals(11, card.getValue());
    }
    
    @Test
    public void testGetSuitEnum() {
        Card card = new Card(5, Card.HEARTS);
        assertEquals(Card.Suit.HEARTS, card.getSuitEnum());
    }
    
    @Test
    public void testGetValueEnum() {
        Card card = new Card(13, Card.DIAMONDS);
        assertEquals(Card.Value.KING, card.getValueEnum());
    }
    
    @Test
    public void testGetSuitAsString() {
        Card card = new Card(8, Card.CLUBS);
        assertEquals("Clubs", card.getSuitAsString());
    }
    
    @Test
    public void testGetValueAsString() {
        Card card = new Card(2, Card.SPADES);
        assertEquals("2", card.getValueAsString());
    }
    
    @Test
    public void testToString() {
        Card card = new Card(10, Card.HEARTS);
        assertEquals("10 of Hearts", card.toString());
    }
}
