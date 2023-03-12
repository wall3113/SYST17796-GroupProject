/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;


import java.util.ArrayList;
import java.util.Collections;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author ChiYinIp, 03/11/2023
 */
public class Game {
        
        private ArrayList<Card> cards;
        
        public Game() {
            cards = new ArrayList<>();
        }
        
        public void clear() {
            cards.clear();
        }
        
        public void addCard(Card card) {
            if (card != null) {
                cards.add(card);
            }
        }
        
        public void removeCard(Card card) {
            cards.remove(card);
        }
        
        public void removeCard(int position) {
            if (position >= 0 && position < cards.size()) {
                cards.remove(position);
            }
        }
        
        public int getCardCount() {
            return cards.size();
        }
        
        public Card getCard(int position) {
            if (position >= 0 && position < cards.size()) {
                return cards.get(position);
            }
            return null;
        }
        
        public void sortBySuit() {
            Collections.sort(cards, new CardSuitComparator());
        }
        
        public void sortByValue() {
            Collections.sort(cards, new CardValueComparator());
        }
        
        private static class CardSuitComparator implements java.util.Comparator<Card> {
            public int compare(Card card1, Card card2) {
                int suit1 = card1.getSuit();
                int suit2 = card2.getSuit();
                if (suit1 < suit2) {
                    return -1;
                } else if (suit1 > suit2) {
                    return 1;
                } else {
                    return card1.getValue() - card2.getValue();
                }
            }
        }
        
        private static class CardValueComparator implements java.util.Comparator<Card> {
            public int compare(Card card1, Card card2) {
                int value1 = card1.getValue();
                int value2 = card2.getValue();
                if (value1 < value2) {
                    return -1;
                } else if (value1 > value2) {
                    return 1;
                } else {
                    return card1.getSuit() - card2.getSuit();
                }
            }
        }
        
    }