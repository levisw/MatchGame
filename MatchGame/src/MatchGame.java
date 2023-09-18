import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * The MatchGame class uses a mix of methods, instance fields, class constants, and a 
 * constructor to create a game that uses the cards from the Deck class which are assigned
 * a grid postion. The user than will click on different cards to match them. There are two
 * modes, easy and hard, where easy only has to match the value and the hard matches the color
 * and value.
 * @author Levi Whitener
 */
public class MatchGame {
    
    /** constant representing the number of rows in the grid */
    public static final int ROWS = 4;
    
    /** constant representing the number of columns in the grid */
    public static final int COLS = 13;
    
    /** A Deck object that will be used as the deck of cards for the game */
    private Deck deck;
    
    /** A Grid object that will be used as the grid that represents the arragment of the cards */
    private Grid grid;
    
    /** An integer that represents the number of correct guesses */
    private int numberOfCorrectGuesses;
    
    /** An integer that represents the number of total guesses */
    private int numberOfGuesses;
    
    /** A boolean object that corresponds to the difficulty of the game */
    private boolean isEasy;
    
    /**
     * Constructs a new MatchGame object
     * @param isTesting a boolean to determine if the code will be in test mode
     * @param isEasy a boolean to determine the difficulty of the mode
     */
    public MatchGame(boolean isTesting, boolean isEasy) {
        this.isEasy = isEasy;
        deck = new Deck();
        if (!isTesting) {
            deck.shuffle();
        }
        grid = new Grid(ROWS, COLS);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Card nextCard = deck.nextCard();
                grid.setCard(row, col, nextCard);
            } // For the nested for loop
        } // For the for loop
    } // For the MatchGame constructor

    
    /**
     * Used to get the number of guesses
     * @return an integer that represents the number of guesses
     */
    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }
    
    /**
     * Used to get the number of correct guesses
     * @return an integer that represents the number of correct guesses
     */
    public int getNumberOfCorrectGuesses() {
        return numberOfCorrectGuesses;
    }
    
    /**
     * Used to get the average of correct guesses
     * @return a double that represents the average number of correct guesses,
     *          if the number of guesses is 0, return is 0
     */
    public double getGuessAverage() {
        if (numberOfCorrectGuesses == 0 || numberOfGuesses == 0) {
            return 0;
        } else {
            return (double) numberOfCorrectGuesses / numberOfGuesses;
        }
    }
    
    /**
     * Used to get the representation of the Card at the given row and column
     * @param row the row of the card
     * @param col the column of the card
     * @return the card representation
     * @throws IllegalArgumentException if row is less than 1 or greater than the number of rows
     * @throws IllegalArgumentException if col is less than 1 or greater than the number of columns
     */
    public String getCardName(int row, int col) {
        if (row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }
        return grid.getCard(row, col).toString();
    }
    
   /**
    * Returns true if the Card at the given row and col in the Grid has been found, false otherwise.
    * @param row the row number of the Card in the Grid.
    * @param col the column number of the Card in the Grid.
    * @return true if the Card at the given row and col in the Grid has been found, false otherwise.
    * @throws IllegalArgumentException if row is less than 1 or greater than the number of rows
    * @throws IllegalArgumentException if col is less than 1 or greater than the number of columns
    */
    public boolean hasBeenFound(int row, int col) {
        if (row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }
        return grid.getCard(row, col).hasBeenFound();
    }
    
   /**
    * This method compares two selected cards to see if they are a match.
    * If both of the Cards are a match the number of correct guesses and guesses
    * increases by 1 and true is returned.
    * If the Cards do not match the number of guesses increases by 1 and false is returned.
    * @param card1Row the row of the first card
    * @param card1Col the column of the first card
    * @param card2Row the row of the second card
    * @param card2Col the column of the second card
    * @return true if the cards match and have not been found, false otherwise
    * @throws IllegalArgumentException if card1Row is less than 1 or 
    *                                   greater than the number of rows
    * @throws IllegalArgumentException if card1Col is less than 1 or 
    *                                   greater than the number of columns
    * @throws IllegalArgumentException if card2Row is less than 1 or 
    *                                   greater than the number of rows
    * @throws IllegalArgumentException if card2Col is less than 1 or 
    *                                   greater than the number of columns
    */
    public boolean isMatch(int card1Row, int card1Col, int card2Row, int card2Col) {
        if (card1Row < 0 || card1Row >= ROWS) {
            throw new IllegalArgumentException("Invalid card1Row");
        }
        if (card1Col < 0 || card1Col >= COLS) {
            throw new IllegalArgumentException("Invalid card1Col");
        }
        if (card2Row < 0 || card2Row >= ROWS) {
            throw new IllegalArgumentException("Invalid card2Row");
        }
        if (card2Col < 0 || card2Col >= COLS) {
            throw new IllegalArgumentException("Invalid card2Col");
        }
    
        Card card1 = grid.getCard(card1Row, card1Col);
        Card card2 = grid.getCard(card2Row, card2Col);
    
        numberOfGuesses++;
    
        if (card1.hasBeenFound() || card2.hasBeenFound()) {
            return false;
        }
    
    
        if (isEasy) {
            if (card1.getValue() == card2.getValue()) {
                numberOfCorrectGuesses++;
                card1.setHasBeenFound(true);
                card2.setHasBeenFound(true);
                return true;
            }
        } else {
            if (card1.getColor().equals(card2.getColor()) && card1.getValue() == card2.getValue()) {
                numberOfCorrectGuesses++;
                card1.setHasBeenFound(true);
                card2.setHasBeenFound(true);
                return true;
            }
        }
    
        return false;
    }

    /**
     * Used to get the Deck that will be used in the matching game
     * @return the deck object that will be used in the matching game
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Used to get the Grid that will be used in the matching game
     * @return the grid object that will be used in the matching game
     */
    public Grid getGrid() {
        return grid;
    }

}