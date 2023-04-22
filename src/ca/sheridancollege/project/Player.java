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

   boolean firstTurn = true;
   boolean split = false;
   boolean hasInsurance = false;
   boolean evenMoney = false;
   boolean gameResult = false;

    // Getter method for hasInsurance
    public boolean getHasInsurance() {
      return hasInsurance;
  }

    public boolean playBlackjack(boolean[] doubleDown) {

        GroupOfCards deck = new GroupOfCards();                  
        BlackjackHand dealerHand = new BlackjackHand();   
        BlackjackHand userHand = new BlackjackHand();    
  
        deck.shuffle();
        dealerHand.addCard( deck.dealCard() );
        dealerHand.addCard( deck.dealCard() );
        userHand.addCard( deck.dealCard() );
        userHand.addCard( deck.dealCard() );
        

        Scanner scan = new Scanner(System.in);
         // Check if insurance or even money options are available
        if (dealerHand.getCard(0).getValue() == 1) {
            if (userHand.getBlackjackValue() == 21) {
               System.out.println("Dealer has the " + dealerHand.getCard(0));
                System.out.print("Do you want to take even money? (Y/N): ");
                char evenMoneyChoice = Character.toUpperCase(scan.next().charAt(0));
                if (evenMoneyChoice == 'Y') {
                    evenMoney = true;
                }
            }
            else {
            System.out.println("Dealer has the " + dealerHand.getCard(0));
            System.out.println("Do you want insurance? (Y/N): ");
            char insuranceChoice = Character.toUpperCase(scan.next().charAt(0));
            if (insuranceChoice == 'Y') {
                hasInsurance = true;
            }}
        }
        
        
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


        // Check if the user can split
        if (userHand.getCard(0).getValue() == userHand.getCard(1).getValue()) {
            split = true;
        }

        
        
 
        while (true) {
             System.out.println();
             System.out.println("------------------------------------");
             System.out.println("Your cards are:");
             for ( int i = 0; i < userHand.getCardCount(); i++ )
             System.out.println("    " + userHand.getCard(i));
             System.out.println("Your total pont is " + userHand.getBlackjackValue());
             System.out.println();
             System.out.println("Dealer is showing the " + dealerHand.getCard(0));
             System.out.println();

             
             System.out.print("Hit (H), Stand (S)");
             if (firstTurn) { // Only show Double (D) option on the first turn
               System.out.print(" or Double (D)");
               if (split) {
                   System.out.print(" or Split (P)");
               }
             }
             System.out.print(" ? ");
             char userAction; 
             
             do {
               userAction = Character.toUpperCase(scan.next().charAt(0));
               if (userAction != 'H' && userAction != 'S' && (firstTurn && userAction != 'D') && (firstTurn && !split && userAction != 'P')) {
                   System.out.print("Please respond H, S");
                   if (firstTurn) {
                       System.out.print(", D");
                       if (split) {
                           System.out.print(", or P");
                       }
                   }
                   System.out.print(": ");
               }
           } while (userAction != 'H' && userAction != 'S' && (firstTurn && userAction != 'D') && (firstTurn && !split && userAction != 'P'));
            
            // If the user stands, the user's turn is over.
             if ( userAction == 'S' ) {
                 System.out.println("User stands.");
                 break;
             }
             // If the user hits, the user gets a card.
             if ( userAction == 'H' ) {
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
               // If the user doubles, the user gets a card and the turn ends.
               if ( firstTurn && userAction == 'D' ) {
                  Card newCard = deck.dealCard();
                  userHand.addCard(newCard);
                  System.out.println();
                  System.out.println("User doubles.");
                  System.out.println("Your card is the " + newCard);
                  System.out.println("Your total is now " + userHand.getBlackjackValue());
                  if (userHand.getBlackjackValue() > 21) {
                        System.out.println();
                        System.out.println("You busted by going over 21.  You lose.");
                        System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                        return false;
                  }
                  doubleDown[0] = true;
                  break;
               }

               if (firstTurn && split && userAction == 'P') {
                  gameResult = handleSplit(deck, dealerHand, userHand, scan);
                  break;
              }
          
               firstTurn = false;

             
        }
 
        System.out.println();
        System.out.println("User's term end.");
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


     private boolean playHand(GroupOfCards deck, BlackjackHand dealerHand, BlackjackHand userHand, Scanner scan) {
      // Move the original logic inside the while loop here, except for the split-related code
  
      // Return the outcome of the hand
      if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
          return false;
      } else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
          return false;
      } else {
          return true;
      }
  }

  private boolean handleSplit(GroupOfCards deck, BlackjackHand dealerHand, BlackjackHand userHand, Scanner scan) {
   // Create two hands and distribute the cards from the userHand
   BlackjackHand userHand1 = new BlackjackHand();
   BlackjackHand userHand2 = new BlackjackHand();
   userHand1.addCard(userHand.getCard(0));
   userHand2.addCard(userHand.getCard(1));

   // Add a new card to each hand
   userHand1.addCard(deck.dealCard());
   userHand2.addCard(deck.dealCard());

   // Play the game with each hand separately
   boolean userWinsHand1 = playHand(deck, dealerHand, userHand1, scan);
   boolean userWinsHand2 = playHand(deck, dealerHand, userHand2, scan);

   // Return the final outcome for the player
   return userWinsHand1 || userWinsHand2;
}


}
