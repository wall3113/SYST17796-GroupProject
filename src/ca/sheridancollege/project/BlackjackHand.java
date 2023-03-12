/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @author ChiYinIp, 03/11/2023
 **/
public class BlackjackHand extends Game {
 
    public int getBlackjackValue() {
        int value = 0;
        boolean hasAce = false;

        for (int i = 0; i < getCardCount(); i++) {
            Card card = getCard(i);
            int cardValue = card.getValue();
            if (cardValue == 1) {
                hasAce = true;
            }
            value += Math.min(cardValue, 10);
        }

        if (hasAce && value + 10 <= 21) {
            value += 10;
        }

        return value;
    }
}
