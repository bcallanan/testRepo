package com.brianc.testRepo;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class ApexApp 
{
    public static void main( String[] args ) {
    
    	String sen = "the quick)(*&^( brown fox jumped)(& over the lazy dogk9";
    	
    	Optional<String> longestWord = Stream.of( sen.split( " ") )
    			.map( word -> word.replaceAll( "[!@#$%^&*()]", "" ) )
    			.max( Comparator.comparingInt( String::length ));
    	System.out.println( longestWord.get());
     }
}
