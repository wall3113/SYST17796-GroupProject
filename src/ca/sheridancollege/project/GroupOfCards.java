/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @author ChiYinIp, 03/11/2023
 **/

import java.util.Random;

public class GroupOfCards {
    
    private static final int NUMBER_OF_CARDS = 52;
    private Card[] deck;
    private int cardsUsed;
    
    public GroupOfCards() {
        deck = new Card[NUMBER_OF_CARDS];
        int i = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck[i++] = new Card(value, suit);
            }
        }
        cardsUsed = 0;
    }
    
    public void shuffle() {
        Random random = new Random();
        for (int i = NUMBER_OF_CARDS - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        cardsUsed = 0;
    }
    
    public int cardsLeft() {
        return NUMBER_OF_CARDS - cardsUsed;
    }
    
    public Card dealCard() {
        if (cardsUsed == NUMBER_OF_CARDS) {
            shuffle();
        }
        return deck[cardsUsed++];
    }
}