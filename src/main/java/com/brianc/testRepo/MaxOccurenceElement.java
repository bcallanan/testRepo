package com.brianc.testRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class MaxOccurenceElement {
	
	/*
	 * Problem Stateament
	 *
	 * Given an array nums of size n, return the majority element.
	 *
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
	 * You may assume that the majority element always exists in the array
	 * and is always more than half of the values in the array.
	 *
	 * ex) Input: nums = [2,2,1,3,1,2,2]
	 * Output: 2
	 */
	 

//    public int majorityElement(int[] nums) {
//        
//    }
	
	public static <T> void  findMatches(List<T> intArray) {


	     System.out.print( "oldschool = " );
	     Map<T, Integer> map = new HashMap<>();

	     for (T t : intArray) {
	         Integer val = map.get(t);
	         map.put(t, val == null ? 1 : val + 1);
	     }

	     Entry<T, Integer> max = null;

	     for (Entry<T, Integer> e : map.entrySet()) {
	         if (max == null || e.getValue() > max.getValue())
	             max = e;
	     }
	     System.out.println( max );

	     System.out.println( "Wont Find dups " );
	     intArray.stream()//( 47,78,78,78,78,78 , 1, 6, 3, 6, 90, 52, 78, 47, 47, 47)
	       .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
	       .entrySet()
	       .stream()
	       .max( Map.Entry.comparingByValue())
	       .ifPresent( System.out::println );

	     System.out.println( "Will Find dups " );
	     List<T> result =
	    		 intArray.stream()
	    		 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
	    		 .entrySet()
	    		 .stream()
	    		 .collect(Collectors.groupingBy(Map.Entry::getValue,
	    				 Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
	    		 .entrySet()
	    		 .stream().max((o1, o2) -> o1.getKey().compareTo(o2.getKey())).map(Map.Entry::getValue)
	    		 .orElse(Collections.emptyList());
	    
	    //.ifPresent( System.out::println );
	   System.out.println( "both " + result);
	     
	     
	}

    public static void main( String[] args ) {
		
    	List<Integer> intArray = Arrays.asList (47, 78,78,78,78,78 , 1, 6, 3, 6, 90, 52, 78, 47, 47, 47, 47, 47); 
	        
	    findMatches( intArray );
    }
}
