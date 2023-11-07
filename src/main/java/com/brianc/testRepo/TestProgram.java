package com.brianc.testRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestProgram {

	public String joinWords( String ... args) {

		String myString = String.join(" ", args);

		return myString;
	}

	public String stringArrayJoiningWords( String[] stringArray ) {

		String myString = Arrays.toString(stringArray);

		return myString;
	}
	
	public String stringJoinReduce( String ... args) {

		StringJoiner joiner = new StringJoiner( " ");
		
		String myString =
				Stream.of( args )
				.map( Object::toString )
				.reduce(( s1,  s2) -> s1 + " " + s2 ).orElse( "");

		Optional<String> myOptionalString =
				Stream.of( args )
				.map( Object::toString )
				.reduce(( s1,  s2) -> s1 + " " + s2 );

		return myString;
	}

	public String collectorsJoiningWords( List< String > stringList ) {

		String myString = stringList.stream().collect( Collectors.joining( " "));
		
		return myString;
	}

}
