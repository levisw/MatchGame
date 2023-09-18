import java.util.*;
import java.io.*;
import java.awt.*;


/**
 * The Grid class uses a mix of methods, instance fields, class constants, and a constructor
 * to create a grid in which cards from the Deck class are assigned a grid postion in order 
 * to create the structure of the matching game
 * @author Levi Whitener
 */
public class Grid {
    
    
    /** integer that represents the number of rows in the Card 2D array */
    private int rows;
    
    /** integer that represents the number of columns in the Card 2D array */
    private int cols;
    
    /** a 2D array consisting of Card objects */
    private Card[][] cards;
    
    
    /**
     * Constructs a new Grid object
     * @param rows the number of rows in the grid
     * @param cols the number of columns in the grid
     * @throws IllegalArgumentException if the rows or columns are less than 1
     */
    public Grid(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Invalid rows/cols");
        }
        this.rows = rows;
        this.cols = cols;
        this.cards = new Card[rows][cols];
    }
    
    /**
     * Sets the card at a specified row and column position in the grid
     * @param row the row position of the card
     * @param col the column position of the card
     * @param card the Card object that is being assigned a postion
     * @throws IllegalArgumentException if the card is null
     * @throws IllegalArgumentException if the row positon is less than 1 or larger that the amount
     *                                  of rows
     * @throws IllegalArgumentException if the column positon is less than 1 or larger that 
     *                                  the amount of columns
     */
    public void setCard(int row, int col, Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Null card");
        }
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid col");
        }
        cards[row][col] = card;
    }
    
    /**
     * Returns the Card object at the specified row and column positon
     * @param row the row position of the card
     * @param col the column position of the card
     * @return card the Card object that is at the specified grid position
     * @throws IllegalArgumentException if the row or column positon is invalid
     */
    public Card getCard(int row, int col) {
        if (row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid col");
        }
        return cards[row][col];
    }
    
    /**
     * Returna String representation of the grid object
     * with each row seperated by a new line and each card seperated by a space
     * @return a String representation of the grid object containing Card objects
     */
    public String toString() {
        String result = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Card card = getCard(row, col);
                if (card != null) {
                    result += card.toString() + " ";
                }   
            } // For the nested for loop
            result = result.trim();
            result += "\n";
        } // For the for loop
        return result;
    }
    
} // For the Grid class