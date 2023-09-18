import java.util.*;
import java.io.*;
import java.awt.*;


/**
 * The Deck class uses a mix of methods, instance fields, class constants, and a constructor
 * to create a deck of 52 cards using the Card class to create each individual card
 * @author Levi Whitener
 */
public class Deck {
    
    /** constant representing the number of cards in a standard deck of cards */
    public static final int CARDS_IN_DECK = 52;
    
    /** constant representing the number of suits in a standard deck of cards */
    public static final int NUMBER_OF_SUITS = 4;
    
    /** An array of Card objects that represents a deck of cards */
    private Card[] cards;
    
    /** An integer that represents the index of the next card to be dealt */
    private int next; 
    
    /**
     * Constructs a standard deck of cards
     */
    public Deck(){
        next = 0; 
        cards = new Card[CARDS_IN_DECK];
        char suit = ' ';
        int nextCard = 0;
        for(int i = 1; i <= NUMBER_OF_SUITS; i++) {
            for (int value = Card.LOWEST_VALUE; value <= Card.HIGHEST_VALUE; value++) {
                if(i == 1) {
                    suit = Card.CLUBS;
                } else if (i == 2) {
                    suit = Card.DIAMONDS;
                } else if (i == 3) {
                    suit = Card.HEARTS;
                } else if (i == NUMBER_OF_SUITS) {
                    suit = Card.SPADES;
                }
                cards[nextCard] = new Card(suit, value);
                boolean isDuplicate = false;
                for (int j = 0; j < nextCard; j++) {
                    if (cards[j].equals(cards[value])) {
                        isDuplicate = true;
                        break;
                    } // For the nested if statement
                } // For the double nested for loop
                nextCard++;
            } // For the nested for loop
        } // For the for loop
    } // For the Deck constructor


    /**
     * Used to get the index of the next card to be dealt
     * @return an integer that represents the index of the next card to be dealt
     */
    public int getNext() {
        return next; 
    }
    
    /**
     * Used to get the array of Card objects that represents a deck of card
     * @return an array of Card objects that represents a deck of card
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * Shuffles the deck of cards
     */
    public void shuffle() {
        Random rand = new Random();
        for (int i = CARDS_IN_DECK - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    
    /**
     * Returns the next card from the deck and increases the index of the next card
     * @return the next card from the deck
     * @throws IllegalArgumentException if all the cards have been dealt
     */
    public Card nextCard() {
        if (next >= CARDS_IN_DECK) {
            throw new IllegalArgumentException("No more cards");
        }
        Card card = cards[next];
        next++;
        return card;
    }
    
    /**
     * Compares the deck to another deck o to check if they are equal
     * @param o the deck object that is compared to this deck
     * @return true if the decks are equal, otherwise false
     */
    public boolean equals(Object o) {
        if (!(o instanceof Deck)) {
            return false;
        }
        Deck otherDeck = (Deck) o;
        if (this.next != otherDeck.next) {
            return false;
        }
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            if (!this.cards[i].equals(otherDeck.cards[i])) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns a String that represets the deck of cards seperated onto indicdual lines
     * @return a String that represents the deck of cards
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < CARDS_IN_DECK; i++) {
            result += "card " + i + ": " + cards[i].toString() + "\n";
        }
        return result;
    }
    
}