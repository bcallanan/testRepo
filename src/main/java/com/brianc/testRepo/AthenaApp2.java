package com.brianc.testRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class AthenaApp2 {
	
    public static List<Integer> processData(List<List<String>> patients, List<List<String>> claims, List<List<String>> charges) {
        // Write your code here
        Map<String, List<String>> chargeMap = new HashMap<>();

        for ( List<String> charge: charges) {
        	List<String> procedureCode = chargeMap.get( charge.get(1));
        	if( procedureCode != null ) {
        		procedureCode.add( charge.get(3) );
        	}
        	else {
        		procedureCode = new ArrayList<>();
        		procedureCode.add( charge.get(3) );
        	}
        	
        	chargeMap.put( charge.get(1), procedureCode);
        }
        
        //List<String> 
        
        Map<String, List<String>> pat = new HashMap<>();
        
        for ( List<String> claim: claims) {
            System.out.println( "claim " + claim );
           // List<String> newClaim = claim.;
            
            List<String> claimValue = pat.get(claim.get(1) );
            List<String> values = chargeMap.get( claim.get(0) );
            
            if ( claimValue == null ) {
            	List<String> newClaim = new ArrayList();
            	newClaim.addAll( claim );
            	newClaim.addAll( values );

            	pat.put( claim.get(1), newClaim );

            }
            else {
//                pat.put( claim.get(1), claimValue + chargeMap.get(claim.get( 0 ) ));

            }
            
        }

//     // Java 8, Convert all Map values  to a List
//        List<Integer> result4 = pat.entrySet()
//        		.stream()
//        		.sorted( (key1, key2) ->  key1.getKey().compareTo( key2.getKey()) )
//        		.map( c -> c.getValue())
//        	.collect(Collectors.toList());
//
        return null; 
      }


    public static void main(String[] args) throws IOException {
    	
    //	2
    	//2
    	List < List<String>> patients = new ArrayList();
    	
    	List<String> pat1  = Arrays.asList( "A123", "15" );
    	List<String> pat2 = Arrays.asList( "B456",  "50" );
    	patients.add( pat1);
    	patients.add( pat2 );
    	
    	List<String> claim1  = Arrays.asList( "101", "A123", "office" );
    	List<String> claim2  = Arrays.asList( "102", "A123", "office" );
    	List<String> claim3  = Arrays.asList( "103", "B456", "office" );
    	List < List<String>> claims = new ArrayList();
    	claims.add( claim1);
    	claims.add( claim2);
    	claims.add( claim3);

    	//4
    	//4
    	List<String> charge1  = Arrays.asList( "8001", "101", "70", "90000");
    	List<String> charge2  = Arrays.asList( "8002", "102", "9", "80000" );
    	List<String> charge3  = Arrays.asList( "8003", "103", "20", "G5000" );
    	List<String> charge4  = Arrays.asList( "8004", "103", "30", "60000" );
    	List < List<String>> charges = new ArrayList();
    	charges.add( charge1);
    	charges.add( charge2);
    	charges.add( charge3);
    	charges.add( charge4);
    	
    	List< Integer> sumOfCharges = processData( patients, claims, charges);
    	
    	
    	sumOfCharges.stream()
    		.forEach( System.out::println);
    	
    }
}
