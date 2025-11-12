// Karis Lewis 
//added javadoc comments on top of comments provided in assignment pdf
package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet models a mathematical 
 * set of integers. A set cannot contain duplicates 
 * and must support standard set operations.
 */

public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();
    	
    /**
     * Clears all elements from the set
     */
    //Clears the internal representation of the set
    public void clear() {
        set.clear();
    }
    
    /**
     * Returns the number of elements in the set
     * @return number of elements in the set
     */
    //Returns the number of elements in the set
    public int length() {
        return set.size();
    }
    
    /**
     * compares this set to another object for equality
     * @param o object to compare
     * @return true if the sets are equal, false otherwise
     */
    /*
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.
     * This overrides the equal method from the Object class.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegerSet)) return false;
        IntegerSet other = (IntegerSet) o;
        return set.containsAll(other.set) && other.set.containsAll(set);
    }
    
    /**
     * checks if value is contained in the set 
     * @param valye the integer to check for 
     * @return true if the value is present, false otherwise
     * @param value
     * @return
     */
    //Returns true if the set contains the value, otherwise false.
    public boolean contains(int value) {
        return set.contains(value);
    }
    
    /**
     * returns the largest element in the set
     * @return largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    //Returns the largest item in the set (throws IllegalStateException if empty).
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }
    
    /**
     * Returns the smallest element in the set
     * @return smallest integer in the set
     * @throws IllegalStateExceeption if the set is empty 
     */
    //Returns the smallest item in the set (throws IllegalStateException if empty).
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.min(set);
    }
    
    /**
     * Adds an element to the set if not already present
     * @param item integer to add
     */
    //Adds an item to the set or does nothing if already present.
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }
    
    /**
     * Removes an element from the set if present 
     * @param item integer to remove
     */
    //Removes an item from the set or does nothing if not there.
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Updates this set to include all unique elements from another set. 
     * @param other set to union with 
     */
    //Set union: modifies this to contain all unique elements in this or other.
    public void union(IntegerSet other) {
        for (int val : other.set) {
            if (!set.contains(val)) {
                set.add(val);
            }
        }
    }
    
    /**
     * Updates this set to keep only elements present in both sets
     * @param other set to intersect with
     */
    //Set intersection: modifies this to contain only elements in both sets.
    public void intersect(IntegerSet other) {
        set.retainAll(other.set);
    }
    
    
    /**
     * Removes elements from this set that are present in another set
     * @param other set containing elements to remove
     */
    //Set difference (this \ other): modifies this to remove elements found in other.
    public void diff(IntegerSet other) {
        set.removeAll(other.set);
    }
    
    /**
     * Replaces this set with elements in the other set that are not in this set
     * (other \ this)
     * @param other set for complement operation 
     */
    //Set complement: modifies this to become (other \ this).
    public void complement(IntegerSet other) {
        List<Integer> temp = new ArrayList<>(other.set);
        temp.removeAll(set);
        set = temp;
    }
    
    /**
     * Checks if the set is empty
     * @return true if the set has no elements, false otherwise
     */
    //Returns true if the set is empty, false otherwise.
    public boolean isEmpty() {
        return set.isEmpty();
    }
    
    /**
     *Returns a string representation of the set
     *@return elements of the set in square brackets
     */
    //Returns a String representation; overrides Object.toString().
    @Override
    public String toString() {
        return set.toString();
    }
}
