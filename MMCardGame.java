//Programmer: Makealah Miller
//Class: CS &145
//Date: 04/25/2023
//Assignment: Lab 4
//Purpose: Initiates and plays a game of blackjack with the user

import java.util.*;

public class MMCardGame
{
   public static void main(String[] args) //start of main
   {
      Scanner input = new Scanner(System.in);
      String menuInput;
      
      System.out.println("Welcome to Cool Kids Blackjack!");
      do //start of do/while for the main menu
      {
        System.out.println("Please type a command.");
        System.out.println("    type r to view a brief summary of the rules");
        System.out.println("    type n to play a new game");
        System.out.println("    type q to quit the program");
        menuInput = input.next();
        
        if(menuInput.equals("r")) //start of if/else for menu selection
        {
          gameRules();
        }
        else if(menuInput.equals("n"))
        {  
           BlackjackGame();
        }
        else if(!menuInput.equals("q"))
        {
           System.out.println("Please enter a valid response.");
        } //end of menu prompt if/else
     } //end of main menu do/while
       while (!menuInput.equals("q"));
       System.out.println("Thanks for playing! Have a great day!");           
   } //end of main method
   
   public static void BlackjackGame() //the method that contains the BlackJack game. 
   {
      DeckOfCards deck = new DeckOfCards(); //utilizes DeckOfCards 
      deck.shuffle();
      Card card; //utilizes Card
      int handPoints = 0; //default for both dealer and hand points is zero 
      int dealerPoints = 0;
      String playerMove = "o";

      Scanner input = new Scanner(System.in); //the scanner for user input
      Stack<Card> playerHand = new Stack<Card>();
      Stack<Card> dealerHand = new Stack<Card>();

      for (int i = 0; i < 2; i++) //start of the for loop to fill player's hand with two initial cards
      {  
         card = deck.dealCard();
         handPoints = handPoints+card.points();
         playerHand.push(card);
         
      } //end of for loop
      
      card = deck.dealCard(); // dealing the dealers initial card. Dealer's second card is dealt later.
      dealerPoints = dealerPoints+card.points();
      dealerHand.push(card);
      
      System.out.println("Your cards are: " + playerHand.toString());
      System.out.println("You currently have " + handPoints + " points.");
      System.out.println("The dealer's cards are: " + dealerHand.toString() 
      + ", [*******************]");
      
      do //start of the do/while loop for the players turn
      {
         if(handPoints < 21) //start of the if/else loop to determine the 
         //player's turn based on current point count. 
         {
            System.out.println("Would you like to (h)it or (s)tand?");
            playerMove = input.next();
         
            if(playerMove.equals("h")) //start if/else loop to take action based on player response
            {
               card = deck.dealCard();
               handPoints = handPoints+card.points();
               playerHand.push(card);
               System.out.println("Your cards are: " + playerHand.toString());
               System.out.println("You currently have " + handPoints + " points.");
            }
            else if(!playerMove.equals("s"))
            {
               System.out.println("Please enter a valid response.");
            }
            else if(playerMove.equals("s"))
            {
               System.out.println("You currently have " + handPoints + " points.");
            } //end of player response if/else loop
            
         }
         else if(handPoints == 21)
         {
            System.out.println("You have Blackjack!");
            break;
         }
         else if(handPoints > 21)
         {
            System.out.println("You bust.");
            break;
         }//end of if/else loop for if player has less than 21 points
         
         } //end of do/while loop for player turn 
         while(!playerMove.equals("s"));
         
         if(handPoints < 21) //start if/else for dealer turn and end game text
         {
            card = deck.dealCard(); //deals the dealer's second card
            dealerPoints = dealerPoints+card.points();
            dealerHand.push(card);
            System.out.println("The dealer's cards are: " + dealerHand.toString());
            System.out.println("The dealer currently has " + dealerPoints + " points.");
            
            do //start do/while loop for dealer's turn if they have less than 17 points
            {
               card = deck.dealCard();
               dealerPoints = dealerPoints+card.points();
               dealerHand.push(card);
               System.out.println("The dealer's cards are: " + dealerHand.toString());
               System.out.println("The dealer currently has " + dealerPoints + " points.");
               
            } //end dealer's turn
            
            while(dealerPoints <= 17);
            
            if(dealerPoints == 21) //start if/else loop to determine end game text if dealer had a turn
            {
               System.out.println("The dealer has blackjack. Sorry, you lose.");
            }
            else if(dealerPoints > 21)
            {
               System.out.println("The dealer busts. You win!");
            }
            else if (dealerPoints > handPoints)
            {
               System.out.println("The dealer is closer to 21. Sorry, you lose.");
            }
            else if(dealerPoints < handPoints)
            {
               System.out.println("You are closer to 21. You win!");
            }
         }
         else if(handPoints == 21) //determins end game text if player busts or has BlackJack before dealer's turn
         {
            System.out.println("You win!");
         }
         else if(handPoints > 21)
         {
            System.out.println("Sorry, you lose.");
         } //end of if/else for end game text and dealer's turn
         
   } //end BlackJack method
   
   public static void gameRules() //start method for printing the rules of the game
   {
      System.out.println("Blackjack is a fun and simple game.");
      System.out.print("Your objective is to get as close as possible to ");
      System.out.println("a score of 21 without going over 21.");
      System.out.println("You and the dealer will both be dealt two cards.");
      System.out.println("You will be able to see the one of the dealer's cards.");
      System.out.println("You will have the option to 'hit', or 'stand'.");
      System.out.println("If you 'hit', you will recieve another card and your points will increase.");
      System.out.println("If you 'stand', you will end the round and your current points will be kept.");
      System.out.println("If your points add to a number higher than 21, you 'bust' and lose.");
      System.out.println("Numbered cards are worth the number on the card in points.");
      System.out.println("Kings, Queens, and Jacks are worth 10 points.");
      System.out.println("An ace is worth 11 points.");
      System.out.println("If you stand without busting, the winner is the player closest to 21.");
   } //end gameRules
} //end MMCardGame class