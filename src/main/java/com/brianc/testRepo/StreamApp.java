package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class StreamApp 
{
    public static void main( String[] args ) {
    	
        System.out.println( "Hello World!" );
        
        //old stlye
        Integer[] intArray = {1 ,2 ,3, 4, 5, 6, 7, 8, 9, 10 };
        
        List< Integer> listOfInts = new ArrayList<>( Arrays.asList( intArray ));
        
		Function<Integer, Integer> timesTwo = ( x) -> x * 2;
		//Function<Integer, Boolean> even = ( x) -> x * 2;
		
		List< Integer> doubled = listOfInts
				.stream()
				.map( timesTwo)
				.collect(Collectors.toList());
		System.out.println( doubled );
		
		Predicate<Integer> isEven = (x) -> x % 2 == 0;
		
		List< Integer> evens = listOfInts
				.stream()
				.map( timesTwo)
				.filter( isEven  )
				.collect(Collectors.toList());
		
		List< Integer> evens1 = listOfInts
				.stream()
				.map( timesTwo)
				.filter( (x) -> x % 2 == 0  )
				.collect(Collectors.toList());

		System.out.println( evens );

		BinaryOperator< Integer> getSumReducerFunc = (acc, x) -> {
			Integer result = acc + x;
			
			System.out.println( "acc =" + acc + ", x =" + x + ", result = " + result);
			return result;
		};
		
		Integer sum = listOfInts
				.stream()
				.reduce( 0, getSumReducerFunc);
		
		System.out.println( sum );
		

		Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
			return (str) -> str.length() > minLength;
		};

		Predicate<String> isLongerThan5 = (str) -> str.length() > 5;
		Predicate<String> isLongerThan3 = createLengthTest.apply( 3);

		String[] wordsArr = { "hello", "functional", "apple", "programming", "is", "cool" };
		List<String> words = new ArrayList<>( Arrays.asList( wordsArr));
		
		List< String> longWords = words
				.stream()
				.filter( isLongerThan3  )
				.collect(Collectors.toList());
		
		System.out.println( longWords );

		List< String> longWords5 = words
				.stream()
				.filter( isLongerThan5  )
				.collect(Collectors.toList());

		List< String> longWords5a = words
				.stream()
				.filter( (str) -> str.length() > 5  )
				.collect(Collectors.toList());

		Map< Integer, List<String>> longWords5b = words
				.stream()
				.collect(Collectors.groupingBy((word) -> word.length() ));

		Map< Boolean, List<String>> longWords5c = words
				.stream()
				.collect( Collectors.partitioningBy(
						(word) -> word.length() > 5 ));

		System.out.println( longWords5 );
		System.out.println( longWords5a );
		System.out.println( longWords5b );
		System.out.println( longWords5c );

		
		List<String> parallelProcessWords = words
				.parallelStream()
				.map((word) -> {
					System.out.println( "Processing uppercase" + word);
					return word.toUpperCase();
				})
				.map((word) -> {
					System.out.println( "add exclamation" + word);
					return word + "!";
				})
				.collect( Collectors.toList());
		
		System.out.println( parallelProcessWords);
    }
}
