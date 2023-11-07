package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class RegexAppString 
{
    public static void main( String[] args ) {
    
    	String regex = "^\\d+\\.\\s\\p{Lu}+.*";
    	String regex1 = "^\\d+\\.\\s[A-Z]+.*";
    	
    	List<String> strings = Arrays.asList( "1. PTYU fmmflksfkslfsm",
    			". PTYU fmmflksfkslfsm", // leading digit
    			"1.PTYU fmmflksfkslfsm", // space after .
    			"1. xPTYU fmmflksfkslfsm",
    			"");                        // empty
    			
      	strings.stream()
 	   .filter( (s) -> s.matches( regex1 ))
 	   .map(( s ) -> { return s + ": true"; })
 	   .forEach( System.out::println);
      	
        List<String> listOfStrings = Arrays.asList( "Big black bug bit a big black dog on his big black nose".split( " ") );
        System.out.println("String " + listOfStrings );

        listOfStrings.stream()
        	.distinct()
        	.forEach( (s) -> System.out.print( s + " "));
        	
        System.out.println();
        
        listOfStrings.stream()
            	.filter( (dupWord) -> Collections.frequency( listOfStrings, dupWord) > 1 )
            	.distinct()
            	.forEach( System.out::println);

        
    	List<String> capStrings = Arrays.asList( "First 3 Capital Words! then 10 TLAs, I Found"); 

    	String capRegex = "(?<=^|[^A-Za-z])([A-Z][a-z]*)(?=[^A-Za-z]|$)";

    	Pattern p = Pattern.compile( capRegex );
    	Matcher matcher = p.matcher("First 3 Capital Words! then 10 TLAs, I Found");
    	List<String> matches = new ArrayList<>();
    	while (matcher.find()) {
    	    matches.add(matcher.group(1));
    	    System.out.println( matcher.group(1));
    	}

        String dupRegex = "\\b(?<duplicateWords>(?<word>\\w+)(?:\\W\\2)+)\\b";
        p = Pattern.compile(dupRegex, Pattern.CASE_INSENSITIVE);

        List<String> dupWords = Arrays.asList(
        		"Goodbye bye bye world world world",
        		"Sam went went to to to his business",
        		"Reya is is the the best player in eye eye game",
        		"in inthe",
        		"Hello hello Ab aB");
        
        for ( String sentence: dupWords) {
	            
	            Matcher m = p.matcher( sentence );
	            
	            // Check for subsequences of input that match the compiled pattern
	            while (m.find()) {
	            	sentence = sentence.replaceAll(m.group("duplicateWords"), m.group("word"));
	            }
	            
	            // Prints the modified sentence.
	            System.out.println(sentence);
        }
        
        List<String> words = Arrays.asList( "The Cat in the Hat is not a cat 1234.".split(" ") );
        String regexWords = "^[A-Z].*$";
        p = Pattern.compile(regexWords);
        for( String word: words ) {
        	Matcher m = p.matcher( word );
        	if ( m.find() ) System.out.println( "matched " + word );
        }
     }
}
