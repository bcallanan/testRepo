package com.brianc.testRepo;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class Pailidrome {
	public static void main(String...args) {
	
		String bobString = "gwertrewg";
		
		boolean foundPallindrome = IntStream.range( 0, bobString.length() / 2 )
			.noneMatch( charIndex -> bobString.charAt( charIndex) != bobString.charAt( bobString.length() - charIndex - 1 ));
		
		System.out.println( bobString + " is a palidrome " + foundPallindrome);
	}
}
