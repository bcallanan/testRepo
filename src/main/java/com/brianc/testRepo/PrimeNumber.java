package com.brianc.testRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class PrimeNumber {
	

    public static boolean isPrime(int i) {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
 }

    public static void checkPrime(List<Integer> intList) {
	    for ( Integer num: intList) {
	          BigInteger bigInteger = BigInteger.valueOf( num );
	          if (bigInteger.isProbablePrime(10))
	        	  System.out.print( num + " ");
	    }
	    System.out.println();
    }

    public static void main(String[] args) throws IOException {
    	
        Scanner in = new Scanner(System.in);
    	List<String> lines = new ArrayList<>();

        while ( in.hasNextLine()) {
            String line = in.nextLine();
            if ( line.isEmpty() ) break;
    		lines.add( line );
    	}
        
        List<Integer> intList = lines.stream()
        .map(Integer::parseInt)
        //.filter( PrimeNumber::isPrime )
        .collect(Collectors.toList());
        
        checkPrime( intList);
        
        final List <String> numbers = new ArrayList<>();    
        lines         .stream()
         .map(Integer::parseInt)
         //.filter( PrimeNumber::isPrime )
         .collect(Collectors.toList())
         .forEach( (n) -> {
        	 if ( isPrime(n)  ) {
        		 numbers.add( n + "");
        	 }
        	 String numList = numbers.stream().
        			 collect( Collectors.joining( " "));
        	 System.out.println( numList ) ;
         });

    }//end of main
 }//end of Solution

