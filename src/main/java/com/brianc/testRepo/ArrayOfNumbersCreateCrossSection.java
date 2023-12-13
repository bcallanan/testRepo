package com.brianc.testRepo;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Result {

	    /*
	     * Complete the 'countPairs' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. INTEGER_ARRAY numbers
	     *  2. INTEGER k
	     
	     distinction [1,2,3]
	   1,1 1,2 1,3 2,2 2,3, 3,3
	     */

	    public static int countPairs(List<Integer> numbers) {

	        System.out.println( numbers);

	        Set<Object> set = new HashSet<>();
	        
	        for(int i = 0 ; i < numbers.size(); i ++){
	        	  for(int j = i+1 ; j < numbers.size(); j ++){
	        		  set.add( numbers.get(i) + "," + numbers.get(j));   
	        	  }
	        }
	        
	        System.out.println( set );

	        return set.size();
	    }
	}


	public class ArrayOfNumbersCreateCrossSection {
	    public static void main(String[] args) throws IOException {
//	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//	        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> numbers = Arrays.asList( 1, 1, 2, 2, 3, 3);//new ArrayList<>();

//	        for (int i = 0; i < numbersCount; i++) {
//	            int numbersItem = Integer.parseInt(bufferedReader.readLine().trim());
//	            numbers.add(numbersItem);
//	        }

//	        int k = Integer.parseInt(bufferedReader.readLine().trim());

	        int result = Result.countPairs(numbers);//, k);

//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedReader.close();
//	        bufferedWriter.close();
	    }
	}
 
