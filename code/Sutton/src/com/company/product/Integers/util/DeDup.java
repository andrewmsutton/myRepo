/*
 * Submitted by:    Andrew Sutton 
 *
 * Consulting Firm: Insight Global
 * 
 * Contact Info:    610.246.3637
 * 
 */
package com.company.product.Integers.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeDup {

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};
    
    private int[] uniqueIntegers;

    /** 
     * Class constructor.
	 * 
	 * @TestCase
     */
    public DeDup() {
    	
    }
    
    /**
     * Sets the array of integers containing no duplicates.  Ordering is dependent on option.
     *
     * @param ints the array of random, unordered integers (may contain duplicates)
	 * @param options integer value defining which type of unique list of integers is requested.  1=SET, 2=SORTED, 3=NATURAL
	 * @return array of unique integers based on superset of ints 
	 * 
	 * @TestCase
     */
    public int[] setUniqueIntegers(int[] ints, int option) {
    	try {
    		if (option == 1) return setUniqueIntegers(ints, IntStream.of(ints).boxed().collect(Collectors.toSet()));
    		if (option == 2) return setUniqueIntegers(ints, new HashMap<Integer, String>());
    		if (option == 3) return setUniqueIntegers(ints, new ArrayList<Integer>());
    		throw new IllegalArgumentException("undefined option "+option);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * Sets the array of integers containing no duplicates.  Ordering is dependent on option.
     *
     * @param ints the array of random, unordered integers (may contain duplicates)
	 * @return array of unique integers based on superset of ints
	 * 
	 * @TestCase
     */
    public int[] setUniqueIntegers(int[] ints, Set<Integer> set){
    	try {
    		return transform(set);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * Sets the array of integers containing no duplicates.  Ordering is ascending.
     *
     * @param ints the array of random, unordered integers (may contain duplicates)
	 * @return array of unique integers based on superset of ints returned in sorted ascending order
	 * 
	 * @TestCase
     */

    public int[] setUniqueIntegers(int[] ints, HashMap<Integer, String> hash){
    	try {
    		int[] sortedInts;
    		for (int i=0; i < ints.length; i++) {
    			hash.put(ints[i],"");
    		}
    		sortedInts = transform(hash.keySet()); 
    		Arrays.sort(sortedInts);
    		return sortedInts;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * Sets the array of integers containing no duplicates.  Ordering is natural based on original order of integers
     *
     * @param ints the array of random, unordered integers (may contain duplicates)
	 * @return array of unique integers based on superset of ints in natural order 
	 * 
	 * @TestCase
     */
    public int[] setUniqueIntegers(int[] ints, ArrayList<Integer> arrayList){
        for (int i=0,j=0; i < ints.length; i++) {
        	if (!arrayList.contains(randomIntegers[i])) arrayList.add(j++,ints[i]);
        }
    	return transform(arrayList);
    }
    
    /**
     * Sets the array of integers containing no duplicates.
     *
     * @param ints the array of random, unordered integers (may contain duplicates)
	 * @return array of unique integers based on superset of ints
	 * 
	 * @TestCase
     */
    private int[] transform(Collection<Integer> elements){
    	uniqueIntegers = new int[elements.size()];
        int i = 0;
        for (Integer element : elements) {
        	uniqueIntegers[i++] = element.intValue();
        }
        return uniqueIntegers;
    }
    
    /**
     * Getter for the class property array of integers containing no duplicates.
     *
	 * @return array of unique integers based on superset of ints
	 * 
	 * @TestCase
     */
    public int[] getUniqueIntegers(){
    	return uniqueIntegers;
    }
    
    /**
     * Builds a String representation of an array of integers.
     *
	 * @return String of CSV of unique integers
	 * 
	 * @TestCase
     */
    public String getUniqueIntegers(int[] ints) {
        StringBuffer string = new StringBuffer();
        
        for (int i=0; i < ints.length; i++) {
        	string.append(ints[i]+", ");
        }
        return string.toString();

    }
    
    public static void main(String [] args) {
    	DeDup test = new DeDup();

    	test.setUniqueIntegers(test.randomIntegers, 1);
    	System.out.println(test.getUniqueIntegers(test.getUniqueIntegers()));
    	
    	test.setUniqueIntegers(test.randomIntegers, 2);
    	System.out.println(test.getUniqueIntegers(test.getUniqueIntegers()));

    	test.setUniqueIntegers(test.randomIntegers, 3);
    	System.out.println(test.getUniqueIntegers(test.getUniqueIntegers()));

    }
}