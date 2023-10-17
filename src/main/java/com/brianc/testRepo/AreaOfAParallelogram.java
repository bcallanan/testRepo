package com.brianc.testRepo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class AreaOfAParallelogram {

	
    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);
        long base = sc.nextLong();
        long height = sc.nextLong();
        if ( base <= 0 || height <= 0 ) {
        	System.out.println( "java.lang.Exception: Breadth and height must be positive" );
        }
        else {
        	System.out.println( base * height );

        }
        
         sc.close();
    }
}
