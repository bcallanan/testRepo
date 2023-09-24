package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class GreetingApp 
{
    public static void main( String[] args ) {
    	
    	GreetingIntf greeting2 = () ->  System.out.println ( "say hello");   

    	greeting2.sayHello();
    	
    	Calculator calc = (int x, int y) -> {
    		
    		Random rand = new Random();
    		int val = rand.nextInt( 50 );
    		
    		return x * y + val;
    	};
    	
    	System.out.println( calc.calculate( 1, 2) );
    
    
    	IntBinaryOperator calculator = (x, y) -> {
    		Random rand = new Random();
    		int val = rand.nextInt( 50 );
    		
    		return x * y + val;
 	
    	};
    	System.out.println( calculator.applyAsInt(1, 2));  	
    }
    
    
}
