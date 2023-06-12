// Card.java
// Card class represents a playing Card 
import java.util.*;

public class Card {
    private final String face; // face of card ("Ace", "Deuce", ...) 
    private final String suit; // suit of card ("Hearts", Diamonds", etc)
    int points;
    
    // two-argument constructor initializes card's face and suit 
    public Card(String cardFace, String cardSuit) 
    {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card 
    } // end of Card Constructor 
    
    
    
    // return String representation of Card
    public String toString() 
    {
        return face + " of " + suit; 
    } // end of toString method 
    
    public int points() //determines the number of points each card is assigned to
    {
       String[] faces = {"X", "X", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
       points = Arrays.asList(faces).indexOf(face);
       
       if(points < 11)
       {
          return points;
       }
       else if (points == 14)
       {
          points = 11;
       }
       else if (points > 10)
       {
          points = 10;
       }
       
       return points;
    } //end points
} // end class Card 