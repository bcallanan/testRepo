package com.brianc.testRepo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PaddingApp 
{
	
    public static String pad( String s, int length, char c, String a ) {
        
        while ( s.length() < length ) {
            
        	if ( a == "front" ) {
        		s = c + s;
        	}
        	else {
        		s = s + c;

        	}
        }
        
        return s;
    }

    public static void main( String[] args ) {
    
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            
            s1 = s1.trim();
            s1 = pad( s1, 15, ' ', "end" );
            String intPad = pad( Integer.toString(x), 3, '0', "front" ); 
            
            System.out.println( s1 + intPad);

            
            //Complete this line
        }
        System.out.println("================================");
     }
}
