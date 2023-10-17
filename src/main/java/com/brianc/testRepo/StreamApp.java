package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class StreamApp {
	
    public static class Customer {
    	
    	private String name;
		boolean hasbeenServed;

		public Customer(String name) {
			
    		this.name = name;
    		hasbeenServed = false;
    	}
		
		void serve() {
			
			hasbeenServed = true;
			System.out.println( "Customer served: " + name ); 
			
			
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Customer [name=" + name + ", hasbeenServed=" + hasbeenServed + "]";
		}
		
		
    }

    public static void main( String[] args ) {
    	
        System.out.println( "Hello World!" );
        
        List< Integer> listOfInts = Arrays.asList( new Integer[] {1 ,2 ,3, 4, 5, 6, 7, 8, 9, 10 });
        
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

		List<String> words = Arrays.asList( new String[] { "hello", "functional", "apple", "programming", "is", "cool" });
		
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
		
		List<String> countries = Arrays.asList( new String[] { "croatia", "canada", "united states", "cazumel"} );
		
		List<String> countriesSorted = countries
				.stream()
				.map( c -> c.toUpperCase() )
				.filter( c -> c.startsWith( "C" ))
				.sorted()
				.collect( Collectors.toList());
				
		System.out.println( countriesSorted);

		countries.stream()
				.map( c -> c.toUpperCase() )
				.filter( c -> c.startsWith( "C" ))
				.sorted()
				.forEach( c -> System.out.println( c) );
		
		
		printShopingList( "bread", "milk", "butter" );
		
		
		Building building = new Building();
		Office office = new Office();
		build( building );
		build( office );
		
		List<Building> buildings = new ArrayList<> ();
		buildings.add( new Office());
		buildings.add( new Building());
		printBuildings(buildings);
		
		List<Office> offices = new ArrayList<> ();
		offices.add( new Office());
		offices.add( new Office());
		printBuildings(offices);

		List<House> houses = new ArrayList<> ();
		houses.add( new House());
		houses.add( new House());
		addHouseToList( houses);
		printBuildings( houses);
		addHouseToList( buildings);

		LinkedList<String> myList = new LinkedList();
		myList.add("a");
		myList.add("b");
		
		myList.add( 1, "c");
		System.out.println( myList );
		
		LinkedList<Customer> customerList = new LinkedList();
		
		customerList.add( new Customer( "bob" ) );
			
		customerList.add( new Customer("fred") );
		customerList.add( new Customer("sally") );
		System.out.println( "Customers: " + customerList ); 

		serveCustomer( customerList );
		System.out.println( "Customers: " + customerList ); 

    
    }
    
	static void serveCustomer( LinkedList<Customer> queue) {
		
		Customer c = queue.poll();
		c.serve();
		
		
	}
	
    static void build( Building building) {
    	
    	System.out.println( "building: " + building.toString());
    	
    }
	private static void printBuildings( List< ? extends Building> buildings ) { }

	private static void addHouseToList( List< ? super House> buildings ) {
		
		
	}


	private static void printShopingList(String... stringArgs ) {
		
		// Print the shopping list *any* number of args
		
		for( String arg: stringArgs) {
			System.out.println( "Arg = " + arg );
		}
		
	}
}
