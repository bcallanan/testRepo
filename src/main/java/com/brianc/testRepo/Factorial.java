package com.brianc.testRepo;

import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class Factorial {

	public static long factorial(long n) {
		if (n == 1)
			return 1;
		else
			return (n * factorial(n - 1));
	}
	
	public static void main(String[] args) throws IOException {

		long fact = factorial( 10 );
    	
    	System.out.println( "facorial of 10 = " + fact);
    }
}
