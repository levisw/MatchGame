import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;

/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Levi Whitener
 */
public class CardTest {

    /** card two of hearts for testing */
    private Card twoOfHearts;

    /** card eight of clubs for testing */
    private Card eightOfClubs;
    
    /**
     * Create cards for testing
     */
    @BeforeEach
    public void setUp() {
        twoOfHearts = new Card('h', 2);
        eightOfClubs = new Card('c', 8);
    }

    /**
     * Tests constants
     */
    @Test
    public void testConstants() {
        assertEquals('c', Card.CLUBS, "CLUBS");
        assertEquals('d', Card.DIAMONDS, "DIAMONDS");
        assertEquals('s', Card.SPADES, "SPADES");
        assertEquals('h', Card.HEARTS, "HEARTS");
        assertEquals(2, Card.LOWEST_VALUE, "LOWEST_VALUE");
        assertEquals(14, Card.HIGHEST_VALUE, "HIGHEST_VALUE]");
    }

    /**
     * Tests constructor preconditions
     */
    @Test
    public void testConstructorPreConditions() {
        // Testing constructor with low invalid value
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('h', 1), "Constructor value 1");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 1 message");
                
        // Testing constructor with high invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('s', 15), "Constructor value 15");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 15 message");
                
        // Testing constructor with invalid suit and invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('w', 0), "Constructor suit w value 0");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit w value 0 message");
                
        // Testing constructor with invalid lowercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('x', 5), "Constructor suit x");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit x message");
                
        // Testing constructor with invalid uppercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('D', 5), "Constructor suit D");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit D message");
    }
    
    /**
     * Test getSuit() for two of hearts
     */
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals('h', twoOfHearts.getSuit(), "twoOfHearts suit");
    }
   
    /**
     * Test getSuit() for eight of clubs
     */
    @Test
    public void testGetSuitEightOfClubs() {
        assertEquals('c', eightOfClubs.getSuit(), "eightOfClubs suit");
    }
    
    /**
     * Test getValue() for two of hearts
     */
    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals( 2, twoOfHearts.getValue(), "twoOfHearts value");
    }
    
    /**
     * Test getValue() for eight of clubs
     */
    @Test
    public void testGetValueEightOfClubs() {
        assertEquals( 8, eightOfClubs.getValue(), "eightOfClubs value");
    }

    /**
     * Test getColor() for two of hearts
     */
    @Test
    public void testGetColorTwoOfHearts() {
        assertEquals(Color.RED, twoOfHearts.getColor(), "twoOfHearts color");
    }
    
    /**
     * Test getColor() for eight of clubs
     */
    @Test
    public void testGetColorEightOfClubs() {
        assertEquals(Color.BLACK, eightOfClubs.getColor(), "eightOfClubs color");
    }
    
    /**
     * Test toString() for two of hearts
     */
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("h2", twoOfHearts.toString(), "twoOfHearts toString");
    }
    
    /**
     * Test toString() for eight of clubs
     */
    @Test
    public void testToStringEightOfClubs() {
        assertEquals("c8", eightOfClubs.toString(), "eightOfClubs toString");
    }

    /**
     * Test hasBeenFound() for two of hearts
     */
    @Test
    public void testHasBeenFoundTwoOfHearts() {
        assertFalse(twoOfHearts.hasBeenFound(), "twoOfHearts hasBeenFound");
    }
    
    /**
     * Test hasBeenFound() for eight of clubs
     */
    @Test
    public void testHasBeenFoundEightOfClubs() {
        assertFalse(eightOfClubs.hasBeenFound(), "eightOfClubs hasBeenFound");
    }

    /**
     * Test setHasBeenFound() for two of hearts
     */
    @Test
    public void testSetHasBeenFoundTwoOfHearts() {
        twoOfHearts.setHasBeenFound(true);
        assertTrue(twoOfHearts.hasBeenFound(), "twoOfHearts setHasBeenFound true");
        twoOfHearts.setHasBeenFound(false);
        assertFalse(twoOfHearts.hasBeenFound(), "twoOfHearts setHasBeenFound false");
    }
    
    /**
     * Test setHasBeenFound() for eight of clubs
     */
    @Test
    public void testSetHasBeenFoundEightOfClubs() {
        eightOfClubs.setHasBeenFound(true);
        assertTrue(eightOfClubs.hasBeenFound(), "eightOfClubs setHasBeenFound true");
        eightOfClubs.setHasBeenFound(false);
        assertFalse(eightOfClubs.hasBeenFound(), "eightOfClubs setHasBeenFound false");
    }

    /**
     * Test hasSameValue() for two of hearts
     */
    @Test
    public void testHasSameValue() {
        assertTrue(twoOfHearts.hasSameValue(new Card('c', 2)), "twoOfHearts has same value");
        assertFalse(twoOfHearts.hasSameValue(new Card('s', 3)), "twoOfHearts has different value");
    }

    /**
     * Test hasSameValue() for eight of clubs
     */
    @Test
    public void testHasSameValue2() {
        assertTrue(eightOfClubs.hasSameValue(new Card('s', 8)), "eightOfClubs has same value");
        assertFalse(eightOfClubs.hasSameValue(new Card('d', 3)), 
                    "eightOfClubs has different value");
    }
    
    /**
     * Test hasSameValueAndColor() for two of hearts
     */
    @Test
    public void testHasSameValueAndColor() {
        assertTrue(twoOfHearts.hasSameValueAndColor(new Card('d', 2)),
                   "twoOfHearts has same value and color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('s', 3)),
                    "twoOfHearts has different value and color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('d', 8)),
                    "twoOfHearts has different value and same color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('s', 2)), 
                    "twoOfHearts has same value and different color");
    }
    
    /**
     * Test hasSameValueAndColor() for eight of clubs
     */
    @Test
    public void testHasSameValueAndColor2() {
        assertTrue(eightOfClubs.hasSameValueAndColor(new Card('s', 8)),
                   "eightOfClubs has same value and color");
        assertFalse(eightOfClubs.hasSameValueAndColor(new Card('h', 7)),
                    "eightOfClubs has different value and color");
        assertFalse(eightOfClubs.hasSameValueAndColor(new Card('s', 11)),
                    "eightOfClubs has different value and same color");
        assertFalse(eightOfClubs.hasSameValueAndColor(new Card('d', 8)), 
                    "eightOfClubs has same value and different color");
    }

    /**
     * Test equals() for two of hearts
     */
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue(twoOfHearts.equals(twoOfHearts), "twoOfHearts equals with same instance");
        assertTrue(twoOfHearts.equals(new Card('h', 2)), 
                   "twoOfHearts equals with different instances");
        assertFalse(twoOfHearts.equals(new Card('h', 4)), "twoOfHearts with different value");
        assertFalse(twoOfHearts.equals(new Card('s', 2)), "twoOfHearts with different suit");
        assertFalse(twoOfHearts.equals(new Card('c', 5)), 
                    "twoOfHearts with different value and suit");
        assertFalse(twoOfHearts.equals(null), "twoOfHearts compared to null object");
        assertFalse(twoOfHearts.equals("twoOfHearts"), "twoOfHearts compared to String");
    }

    /**
     * Test equals() for eight of clubs
     */
    @Test
    public void testEqualsEightOfClubs() {
        assertTrue(eightOfClubs.equals(eightOfClubs), "eightOfClubs equals with same instance");
        assertTrue(eightOfClubs.equals(new Card('c', 8)), 
                   "eightOfClubs equals with different instances");
        assertFalse(eightOfClubs.equals(new Card('c', 4)), "eightOfClubs with different value");
        assertFalse(eightOfClubs.equals(new Card('d', 8)), "eightOfClubs with different suit");
        assertFalse(eightOfClubs.equals(new Card('h', 5)), 
                    "eightOfClubs with different value and suit");
        assertFalse(eightOfClubs.equals(null), "eightOfClubs compared to null object");
        assertFalse(eightOfClubs.equals("eightOfClubs"), "eightOfClubs compared to String");
    }

}