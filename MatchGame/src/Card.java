import java.util.*;
import java.io.*;
import java.awt.*;


/**
 * The Card class uses a mix of methods, instance fields, class constants, and a constructor
 * to create cards that correspond to the cards of a standard deck of 52 playing cards
 * @author Levi Whitener
 */
public class Card {
    
    /** constant representing the character value of clubs */
    public static final char CLUBS = 'c';
    
    /** constant representing the character value of diamonds */
    public static final char DIAMONDS = 'd';
    
    /** constant representing the character value of hearts */
    public static final char HEARTS = 'h';
    
    /** constant representing the character value of spades */
    public static final char SPADES = 's';
    
    /** constant representing the minimum card value */
    public static final int LOWEST_VALUE = 2;
    
    /** constant representing the maximum card value */
    public static final int HIGHEST_VALUE = 14;

    /** The suit that will be used for a card */
    private char suit;
    
    /** The value that will be used for a card */
    private int value;
    
    /** The color that will be used for a card */
    private Color color;
    
    /** The boolean object corresponding to if a card has been found  */
    private boolean hasBeenFound;


    /**
     * Constructs a Card object with a specifed suit and value
     * @param suit the suit of the card
     * @param value the value of the card
     * @throws IllegalArgumentException if the suit is not one of the four suits of a deck of cards
     * @throws IllegalArgumentException if the value of a card is to equal to a number in the 
     *                                    range of 2 through 14 inclusive
     */
    public Card(char suit, int value) {
        if (suit != CLUBS && suit != DIAMONDS && suit != HEARTS && suit != SPADES) {
            throw new IllegalArgumentException("Invalid suit");
        }
        if (value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.suit = suit;
        this.value = value;
        if (suit == DIAMONDS || suit == HEARTS) {
            this.color = Color.RED;
        } else {
            this.color = Color.BLACK;
        }
        this.hasBeenFound = false;
    } // For the Card constructor


    /**
     * Used to get the suit of a card
     * @return a character representing the suit of a card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * Used to get the value of a card
     * @return an integer representing the value of a card
     */
    public int getValue() {
        return value;
    }

    /**
     * Used to get the color of a card
     * @return the color of the card as a Color object
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns a boolean value indicating if a card has been found or not
     * @return true if the card has been found, otherwise it returns false
     */
    public boolean hasBeenFound() {
        return hasBeenFound;
    }

    /**
     * Sets the boolean value indicating if a card has been found or not
     * @param hasBeenFound true if the card is found, otherwise false
     */
    public void setHasBeenFound(boolean hasBeenFound) {
        this.hasBeenFound = hasBeenFound;
    }

    /**
     * Compares the value of this card to another card
     * @param other the card to compare
     * @return true if the cards have the same value, otherwise false
     */
    public boolean hasSameValue(Card other) {
        return this.value == other.value;
    }

    /**
     * Compares the value and color of this card to another card
     * @param other the card to compare
     * @return true if the cards have the same color and value, otherwise false
     */
    public boolean hasSameValueAndColor(Card other) {
        return this.value == other.value && this.color.equals(other.color);
    }

    /**
     * Compares this card to a different card
     * @param o the card to compare to
     * @return true if the cards match, otherwise false
     */
    public boolean equals(Object o) {
        if (!(o instanceof Card)) {
            return false;
        }
        Card other = (Card) o;
        return this.suit == other.suit && this.value == other.value 
                && this.color.equals(other.color)
                && this.hasBeenFound == other.hasBeenFound;
    }

    /**
     * Returns a string representation of a card
     * @return a string that has the card's suit and value
     */
    public String toString() {
        return suit + "" + value;
    }

} // For the Card class

