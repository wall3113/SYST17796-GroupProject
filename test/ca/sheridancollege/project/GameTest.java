package ca.sheridancollege.project;

import static org.junit.Assert.assertEquals;
import org.junit.Test;




/**
 * Test class for the Game class.
 */
public class GameTest {

    /**
     * Test the clear method of the Game class.
     */
    @Test
    public void testClear() {
        Game game = new Game();
        game.addCard(new Card(2, 3));
        game.addCard(new Card(4, 1));
        game.clear();
        assertEquals(0, game.getCardCount());
    }

    /**
     * Test the addCard method of the Game class.
     */
    @Test
    public void testAddCard() {
        Game game = new Game();
        Card card = new Card(2, 3);
        game.addCard(card);
        assertEquals(1, game.getCardCount());
        assertEquals(card, game.getCard(0));
    }

    /**
     * Test the removeCard method of the Game class (by card).
     */
    @Test
    public void testRemoveCardByCard() {
        Game game = new Game();
        Card card1 = new Card(2, 3);
        Card card2 = new Card(4, 1);
        game.addCard(card1);
        game.addCard(card2);
        game.removeCard(card1);
        assertEquals(1, game.getCardCount());
        assertEquals(card2, game.getCard(0));
    }

    /**
     * Test the removeCard method of the Game class (by position).
     */
    @Test
    public void testRemoveCardByPosition() {
        Game game = new Game();
        Card card1 = new Card(2, 3);
        Card card2 = new Card(4, 1);
        game.addCard(card1);
        game.addCard(card2);
        game.removeCard(0);
        assertEquals(1, game.getCardCount());
        assertEquals(card2, game.getCard(0));
    }

    /**
     * Test the getCard method of the Game class.
     */
    @Test
    public void testGetCard() {
        Game game = new Game();
        Card card1 = new Card(2, 3);
        Card card2 = new Card(4, 1);
        game.addCard(card1);
        game.addCard(card2);
        assertEquals(card1, game.getCard(0));
        assertEquals(card2, game.getCard(1));
    }
}