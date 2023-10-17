package com.brianc.testRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class addem {

    protected static class MyMath {
        public static Function< Integer, Integer> createMulitplier( Integer y) {
            return ( Integer x ) -> x * y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Function< Integer, Integer > timesTwo = MyMath.createMulitplier( n );
        
        for( int i=1; i <= 10; i ++ ) {
        	
            System.out.println( n + " x " + i + " = " +  timesTwo.apply(i));

        }

        bufferedReader.close();
    }
}
