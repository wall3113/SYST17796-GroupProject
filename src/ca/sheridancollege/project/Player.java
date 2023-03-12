/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author ChiYinIp, 03/11/2023
 */
public class Player {

    boolean playBlackjack() {

 
        GroupOfCards deck = new GroupOfCards();                  
        BlackjackHand dealerHand = new BlackjackHand();   
        BlackjackHand userHand = new BlackjackHand();    
  
        deck.shuffle();
        dealerHand.addCard( deck.dealCard() );
        dealerHand.addCard( deck.dealCard() );
        userHand.addCard( deck.dealCard() );
        userHand.addCard( deck.dealCard() );
        
        
        
        if (dealerHand.getBlackjackValue() == 21) {
             System.out.println("Dealer has the " + dealerHand.getCard(0)+ " and the " + dealerHand.getCard(1) + ".");
             System.out.println("User has the " + userHand.getCard(0)+ " and the " + userHand.getCard(1) + ".");
             System.out.println("------------------------------------");
             System.out.println("Dealer has Blackjack.  Dealer wins.");
             return false;
        }
        
        if (userHand.getBlackjackValue() == 21) {
             System.out.println("Dealer has the " + dealerHand.getCard(0)+ " and the " + dealerHand.getCard(1) + ".");
             System.out.println("User has the " + userHand.getCard(0)+ " and the " + userHand.getCard(1) + ".");
             System.out.println("------------------------------------");
             System.out.println("You have Blackjack.  You win.");
             return true;
        }
        
 
        while (true) {
            
             Scanner scan = new Scanner(System.in);
             System.out.println();
             System.out.println("------------------------------------");
             System.out.println("Your cards are:");
             for ( int i = 0; i < userHand.getCardCount(); i++ )
                System.out.println("    " + userHand.getCard(i));
             System.out.println("Your total pont is " + userHand.getBlackjackValue());
             System.out.println();
             System.out.println("Dealer is showing the " + dealerHand.getCard(0));
             System.out.println();
             System.out.print("Hit (H) or Stand (S)? ");
             char userAction; 
             do {
                 userAction = Character.toUpperCase(scan.next().charAt(0));
                 if (userAction != 'H' && userAction != 'S')
                     System.out.print("Please respond H or S: ");
             } while (userAction != 'H' && userAction != 'S');
  
             if ( userAction == 'S' ) {
                 break;
             }
             else {
                 Card newCard = deck.dealCard();
                 userHand.addCard(newCard);
                 System.out.println();
                 System.out.println("User hits.");
                 System.out.println("Your card is the " + newCard);
                 System.out.println("Your total is now " + userHand.getBlackjackValue());
                 if (userHand.getBlackjackValue() > 21) {
                     System.out.println();
                     System.out.println("You busted by going over 21.  You lose.");
                     System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                     return false;
                 }
             }
 
             
        } 
 
        System.out.println();
        System.out.println("User stands.");
        System.out.println("Dealer's cards are");
        System.out.println("    " + dealerHand.getCard(0));
        System.out.println("    " + dealerHand.getCard(1));
        while (dealerHand.getBlackjackValue() <= 16) {
           Card newCard = deck.dealCard();
           System.out.println("Dealer hits and gets the " + newCard);
           dealerHand.addCard(newCard);
           System.out.println("Dealer's total is now " + dealerHand.getBlackjackValue());
           if (dealerHand.getBlackjackValue() > 21) {
              System.out.println();
              System.out.println("Dealer busted by over 21.  You win.");
              return true;
           }
        }       
        
        System.out.println();
        if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
           System.out.println("It's a tie. Dealer wins You lose.");
           return false;
        }
        else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
           System.out.println("Dealer wins, " + dealerHand.getBlackjackValue() + " points to " + userHand.getBlackjackValue() + ".");
           return false;
        }
        else {
           System.out.println("You win, " + userHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
           return true;
        }
  
     } 
}
