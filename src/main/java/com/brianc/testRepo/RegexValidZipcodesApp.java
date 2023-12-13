package com.brianc.testRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class RegexValidZipcodesApp 
{
    public static void main( String[] args ) {
    	
        System.out.println( "Hello World!" );
        
        // mix in numbers 12345
        // 09384-9849
        // ahjdhjfd
        
        // list of string to output 
        //zip code : yes
        //adjdhdfgj: no
        
        // 093122=-9490: yes
        
        
		Predicate<String> isZipcode = (str) -> {
			boolean isRegularZip =  str.matches("[0-9]{5}" );
			//if ( isRegularZip) return true;

			if ( str.matches("^([0-9]{5})|([0-9]{5})\\-([0-9]{4})" )  ) {
				return true;
			}

			boolean isExtendedZip = str.matches("[0-9]{5}\\-[0-9]{4}");
			if ( isExtendedZip) return isExtendedZip;
			return false;
		};
		
		Predicate<String> isNotZipcode = Predicate.not ( isZipcode );

		
		String[] wordsArr = { "01234", "99999", "12-99999", "BACDE" , " abcde-fghi", "1233-12356", "02871-1409" };
		List<String> words = Arrays.asList( wordsArr);

		List< String> validZipCode = words
				.stream()
				.filter( isZipcode  )
				.map((word) -> {
					return word + ":yes";

				})
				.collect(Collectors.toList());

		System.out.println( validZipCode);

		List< String> nonValidZipCode = words
				.stream()
				.filter( isNotZipcode  )
				.map((word) -> {
					return word + ":no";

				})
				.collect(Collectors.toList());
		System.out.println( nonValidZipCode);

    }
}
