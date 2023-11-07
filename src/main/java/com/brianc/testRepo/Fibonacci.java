package com.brianc.testRepo;

import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Fibonacci {

	public static void printFibonacciSequence(int count) {
		int a = 0;
		int b = 1;
		int c = 1;

		for (int i = 1; i <= count; i++) {
			System.out.print(a + ", ");

            a = b;
			b = c;
			c = a + b;
		}
		System.out.println ("");

	}

	public static int fibonacciRecursive(int count) {
		if (count <= 1) {
			return count;
		}
		
		return fibonacciRecursive(count - 1) + fibonacciRecursive(count - 2);
	}

	public static void fibonacciJava8( int count ) {
		Stream.iterate(new BigInteger[] { BigInteger.ZERO, BigInteger.ONE },
	               p -> new BigInteger[] { p[1], p[0].add(p[1]) })
	      .limit( count )
	      .forEach(p -> System.out.print(p[0] + ", "));
		System.out.println ("");
	
	}

	public static void main(String[] args) throws IOException {

    	System.out.println( "For loop");
    	printFibonacciSequence( 10 );
    	
    	System.out.println( "Recursive form ");
      	for (int i = 0; i < 10; i++) {
      	    System.out.print(fibonacciRecursive(i) + ", ");
    	}
		System.out.println ("");
  
    	System.out.println( "Java 8 fib'o");
    	fibonacciJava8( 10 );

    }
}
