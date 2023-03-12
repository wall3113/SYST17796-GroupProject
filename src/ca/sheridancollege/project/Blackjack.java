/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @author ChiYinIp, 03/11/2023
 **/

import java.util.Scanner;

public class Blackjack extends Player{
    
    public static void main(String[] args) {
    
       int money = 100;          
       int bet;            
       boolean userWins;   
       Scanner scan = new Scanner(System.in);
       System.out.println("Welcome to the game of blackjack.");
    
       while (money > 0) {
            System.out.println("You have " + money + " dollars.");
            while (true) {
                System.out.println("How many dollars do you want to bet? (Enter 0 to end)");
                bet = scan.nextInt();
                if (bet < 0 || bet > money) {
                    System.out.println("Invalid bet amount. Your bet must be between 0 and " + money + ".");
                } else {
                    break;
                }
            }
            if (bet == 0) {
                break;
            }
            Player player = new Player();
            userWins = player.playBlackjack();
            if (userWins) {
                money += bet;
            } else {
                money -= bet;
            }
            System.out.println();
        }
       System.out.println("Good Luck next time!");
       System.out.println("You leave with $" + money + '.');
       scan.close();
    
    } 
    

 
 } 