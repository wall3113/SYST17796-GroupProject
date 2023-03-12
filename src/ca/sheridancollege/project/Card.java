/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @author ChiYinIp, 03/11/2023
 **/
public class Card {
    
    public enum Suit {
        SPADES("Spades"),
        HEARTS("Hearts"),
        DIAMONDS("Diamonds"),
        CLUBS("Clubs");
        
        private final String name;
        
        private Suit(String name) {
            this.name = name;
        }
        
        public String toString() {
            return name;
        }
    }
    
    public enum Value {
        ACE("Ace", 1),
        TWO("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("Jack", 11),
        QUEEN("Queen", 12),
        KING("King", 13);
        
        private final String name;
        private final int value;
        
        private Value(String name, int value) {
            this.name = name;
            this.value = value;
        }
        
        public String toString() {
            return name;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    public static final int SPADES = 0;
    public static final int HEARTS = 1;
    public static final int DIAMONDS = 2;
    public static final int CLUBS = 3;
    
    private final int suit;
    private final int value;
    private final Suit suitEnum;
    private final Value valueEnum;
    
    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
        this.suitEnum = Suit.values()[suit];
        this.valueEnum = Value.values()[value - 1];
    }
        
    public int getSuit() {
        return suit;
    }
    
    public int getValue() {
        return value;
    }
    
    public Suit getSuitEnum() {
        return suitEnum;
    }
    
    public Value getValueEnum() {
        return valueEnum;
    }
    
    public String getSuitAsString() {
        return suitEnum.toString();
    }
    
    public String getValueAsString() {
        return valueEnum.toString();
    }
    
    public String toString() {
        return getValueAsString() + " of " + getSuitAsString();
    }
}
