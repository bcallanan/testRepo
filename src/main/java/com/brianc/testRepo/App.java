package com.brianc.testRepo;

import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * Hello world!
 *
 */
public class App 
{
	protected static class Person {
		private String name;
		private Integer age;
		public Person( String name, Integer age) {
			this.name = name;
			this.age = age;
		}
	}
	
	protected static class DataLoader {

		public final NoArgFunction< Person > loadPerson;
		
		public DataLoader( Boolean isDevelopment) {
			this.loadPerson = isDevelopment ?
					this:: loadPersonFake
					: this::loadPersonReal;
		}
		
		public Person loadPersonReal() {
			System.out.println( "loading person");
			return new Person( "real Pearson", 30 );
		}
		
		public Person loadPersonFake() {
			System.out.println( "return fake person");
			return new Person( "fake Pearson", 100 );
		}
	}
	
	protected static class MyMath {
		
		public static Integer timesTwo (Integer x ) {
			return x * 2;
		}

		public static Integer timesThree (Integer x ) {
			return x * 3;
		}

		public static Integer timesFour (Integer x ) {
			return x * 4;
		}

		public static Integer triple (Integer x ) {
			return x * 3;
		}
		
		public static Integer add( Integer x, Integer y) {
			return x + y;
		}
		public static Integer subtract( Integer x, Integer y) {
			return x - y;
		}
		
		public static Function< Integer, Integer> createMulitplier( Integer y) {
			return ( Integer x ) -> x * y;
		}

		public static Integer combine2And3( BiFunction< Integer, Integer, Integer> combineFunction) {
			
			return combineFunction.apply(2,  3);
		}
	}
    public static void main( String[] args ) {
    	
        System.out.println( "Hello World!" );
        
        Function< Integer, Integer> myTriple = MyMath::triple;
        
        Integer result = myTriple.apply(5);
        System.out.println( "triple " + result);
        
        Function< Integer, Integer> absoluteValue = (x) -> x < 0 ? -x : x;
        
        Function< Integer, Integer> absoluteValue1 = (x) -> {
        	if ( x < 0 ) {
        		return  -x;
        	} else {
        		return x;
        	}
        };
        
        System.out.println( absoluteValue1.apply( -1000 ));
        
        BiFunction< Integer, Integer, Integer> add = (x, y) -> x + y;
        
        System.out.println( "add " + add.apply(5,  6));

        TriFunction<Integer, Integer, Integer, Integer > addThree = ( x, y, z) -> x + y + z;
        System.out.println( "add " + addThree.apply(15, 15, 20));

        NoArgFunction< String > sayHello = () -> "Hello!";
        System.out.println( "say " + sayHello.apply());

        final boolean isDevelopment = false;
        DataLoader dataloader = new DataLoader(isDevelopment);
        System.out.println( dataloader.loadPerson.apply());
        
        System.out.println( MyMath.combine2And3( MyMath::add));
        System.out.println( MyMath.combine2And3( MyMath::subtract));
        
        System.out.println( MyMath.combine2And3((x,y) -> 2 * x + 2 * y ));

        
        NoArgFunction< NoArgFunction< String >> createGreeter = () -> () -> "Hello Function!";
        
        NoArgFunction< String > greeter = createGreeter.apply();
        
        System.out.println( greeter.apply());
        
        Function< Integer, Integer > timesTwo = MyMath.createMulitplier( 2 );
        Function< Integer, Integer > timesThree = MyMath.createMulitplier( 3 );
        Function< Integer, Integer > timesFour = MyMath.createMulitplier( 4 );
        
        System.out.println( timesTwo.apply( 6));
        System.out.println( timesThree.apply(6));
        System.out.println( timesFour.apply(6));

        NoArgFunction< NoArgFunction< String >> createGreeter2 = () -> {
        	String name = "Bob";
        	return () -> "Hello, " + name;
        };
        
        NoArgFunction< String > greeter2 = createGreeter2.apply();

        System.out.println( greeter2.apply());

        
        BiFunction<Float, Float, Float> divide = (x, y ) -> x/ y;
        
        Function< BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>>  secondArgIsntZeroCheck =
        		(func) -> (x, y) -> {
        			if ( y == 0f ) {
        				System.out.println ( "divide by zero");
        				return 0f;
        			}
        			
        			return func.apply(x, y);
        		};
    
        BiFunction< Float, Float, Float> divideSafe = secondArgIsntZeroCheck.apply(divide);	
        
        System.out.println( divideSafe.apply( 5f,  0f));
        System.out.println( divideSafe.apply( 5f,  1f));
    }
}
