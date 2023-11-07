package com.brianc.testRepo;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class FizzBuzzJava8 {

    public static void doStreamFizzBuzz(int n) {
        IntStream.rangeClosed(1, n)
            .mapToObj( FizzBuzzJava8 :: mapIntToFizzBuzz )
            .forEach( System.out::println );
    }
    
    public static String mapIntToFizzBuzz( int i ) {

    	if(i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        }
        
        if(i % 3 == 0) {
            return "Fizz";
        }
        
        if(i % 5 == 0) {
            return "Buzz";
        }
        
        return Integer.toString(i);
    }
    
    public static void main(String args[]) {
        doStreamFizzBuzz(31);
    }
}
