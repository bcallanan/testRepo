package com.brianc.testRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class addem {

    protected static class MyMathAddem {
        public static Function< Integer, Integer> createMulitplier( Integer y) {
            return ( Integer x ) -> x * y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Function< Integer, Integer > timesTwo = MyMathAddem.createMulitplier( n );
        
        for( int i=1; i <= 10; i ++ ) {
        	
            System.out.println( n + " x " + i + " = " +  timesTwo.apply(i));

        }

        List<Integer> numbers = Arrays.asList( 1 ,4, 6, 7, 8, 9);
        
        //sum of all even numbers
        System.out.println ( sumWithCondition(numbers, i -> i % 2==0) );
        
        //sum of all numbers greater than 5
        System.out.println ( sumWithCondition(numbers, i -> i > 5) );
        
        bufferedReader.close();
    }
    
    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
	    return numbers.parallelStream()
	    		.filter(predicate)
	    		.mapToInt(i -> i)
	    		.sum();
	}
}
