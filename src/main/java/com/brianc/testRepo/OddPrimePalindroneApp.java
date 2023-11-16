package com.brianc.testRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class MyMath {
	
	public MyMath() {
	}
	
	public static boolean checker( PerformOperation p, int num ) {
		return p.check( num );
	}
	
	public PerformOperation isOdd() {
		PerformOperation isOdd = (num) -> num % 2 > 0;
		return isOdd;
	}

	public PerformOperation isPrime() {
		
    	PerformOperation isPrime = (num) -> num > 1 && IntStream.range( 2,  num).noneMatch( index -> num % index == 0 );
    	
    	//or
    	// isPrime = (num) -> {
		//            for(int i =2 ; i < num; i++) {
		//                if(num % i == 0) return false;
		//            }
		//            return true;
    	return isPrime;
	}

	public PerformOperation isPalindrome() {
		PerformOperation isPalindrone = ( num ) ->  IntStream.range( 0, Integer.toString(num).length() / 2 )
				.noneMatch( charIndex -> Integer.toString( num ).charAt( charIndex) !=
				Integer.toString( num ).charAt( Integer.toString( num ).length() - charIndex - 1 ));
		
		// or
	    // isPalindrone = ( number ) -> String.valueOf(number).equals(new StringBuilder(String.valueOf(number)).reverse().toString());

		return isPalindrone;
	}
}

interface PerformOperation {
	
	boolean check( int a );
	
}
public class OddPrimePalindroneApp {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		
//		while (T--> 0) {
			//String s = br.readLine().trim();
			//StringTokenizer st = new StringTokenizer(s);
			int ch = 2;//Integer.parseInt(st.nextToken());
			int num = 7;//Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} 
			else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			}
			else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
			}
	//	}
			System.out.println(ans);

    }
}