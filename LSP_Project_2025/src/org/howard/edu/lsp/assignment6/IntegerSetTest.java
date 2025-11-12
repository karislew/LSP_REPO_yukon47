package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/*
 * JUnit tests for IntegerSet class 
 * Testing all public methods for normal behavior and edge cases.
 */
public class IntegerSetTest {
	/*
	 * Tests add() and length() methods
	 * ensuring duplicates are ignored
	 * and length reflects unique element 
	 */
    @Test
    public void testAddAndLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);
        assertEquals(2, set.length());
    }
    
    /*
     * tests clear() and isEmpty() methods
     * verifies that clearing the set results in an empty set
     */
    @Test
    public void testClearAndIsEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.clear();
        assertTrue(set.isEmpty());
    }
    
    /*
     * Tests contains() method.
     * Verifies that it correctly identifies present and non-present elements.
     */
    @Test
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        assertTrue(set.contains(10));
        assertFalse(set.contains(5));
    }
    
    /**
     * Tests largest() and smallest() methods.
     * Checks that they return the correct min and max values.
     */
    @Test
    public void testLargestAndSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(10); set.add(1);
        assertEquals(10, set.largest());
        assertEquals(1, set.smallest());
    }
    
    /**
     * Tests largest() throws IllegalStateException for empty set.
     */
    @Test
    public void testLargestThrowsException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.largest());
    }
    
    /**
     * Tests equals() method.
     * Ensures sets with same elements in different orders are still equal.
     */
    @Test
    public void testEquals() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(1);
        assertTrue(a.equals(b));
    }
    
    /**
     * Tests union() method.
     * Ensures all unique elemnts from another set are added to this set.
     */
    @Test
    public void testUnion() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); b.add(2);
        a.union(b);
        assertTrue(a.contains(1));
        assertTrue(a.contains(2));
    }
    
    /**
     * Tests intersection() method. 
     * Ensures this set only contains elements present in both sets.
     */
    @Test
    public void testIntersect() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.intersect(b);
        assertEquals("[2]", a.toString());
    }
    
    /**
     * Tests diff() method.
     * Ensures elements in the other set are removed from this set.
     */
    @Test
    public void testDiff() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); b.add(2);
        a.diff(b);
        assertEquals("[1]", a.toString());
    }
    
    /**
     * Tests complement() method.
     * Ensures this set is replaced with all elements of the other set 
     * that are not already in this set 
     * (other \ this)
     */
    @Test
    public void testComplement() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(2); b.add(3);
        a.complement(b);
        assertEquals("[3]", a.toString());
    }
    
    /**
     * Tests toString() method.
     * Ensures the string representation matches [1,2,3] format.
     */
    @Test
    public void testToStringFormatting() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2);
        assertEquals("[1, 2]", set.toString());
    }
}
