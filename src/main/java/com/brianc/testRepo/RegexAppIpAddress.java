package com.brianc.testRepo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Hello world!
 *
 */
public class RegexAppIpAddress 
{
    public static void main( String[] args ) {
    
    	List<String> ipAddresses = Arrays.asList( "000.12.12.034", "121.234.12.12",
    			"23.45.12.56","00.12.123.123123.123", "122.23", "Hello.IP", "000.000.000.000",          // leading 0
                "00.00.00.00",              // leading 0
                "1.2.3.04",                 // leading 0
                "1.02.03.4",                // leading 0
                "1.2",                      // 1 dot
                "1.2.3",                    // 2 dots
                "1.2.3.4.5",                // 4 dots
                "192.168.1.1.1",            // 4 dots
                "256.1.1.1",                // 256
                "1.256.1.1",                // 256
                "1.1.256.1",                // 256
                "1.1.1.256",                // 256
                "-100.1.1.1",               // -100
                "1.-100.1.1",               // -100
                "1.1.-100.1",               // -100
                "1.1.1.-100",               // -100
                "1...1",                    // empty between .
                "1..1",                     // empty between .
                "1.1.1.1.",                 // last .
                "");                        // empty
    			
    	Predicate<String> isValidIPAddress = (str) -> {
    		
    		boolean isTrue = false;
    		if ( str.matches( "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d[1,3])\\.(\\d[1,3])$")) {
    			isTrue = true;
    		}
    		if ( str.matches( "([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})")) {
    			isTrue = true;
    		}
    		if ( str.matches( "([0-9]{1,3}\\.){3}" + "([0-9]{1,3})")) {
    			isTrue = true;
    		}
    		if ( str.matches( "^(([0-9]|0[0-9]|00[0-9]|[0-9][0-9]|[0-1][0-9][0-9]|[0-2][0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$" ) ){
    			isTrue = true;
    		}

    		if ( str.matches( "^(([0-9]|0[0-9]|00[0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$")) {
    			isTrue = true;
    		}
    		else {
    			isTrue = false;
    		}

    		return isTrue;
    	};
    			
    	ipAddresses.stream()
    	   .filter(isValidIPAddress)
    	   .map(( ipAddr ) -> { return ipAddr + ": true"; })
    	   .forEach( System.out::println);
    			

    	
     }
}
