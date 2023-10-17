package com.brianc.testRepo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class DetectIntDataType {

	
    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for( int i=0; i < t; i++) {

            try {
            	
                long x = sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127) System.out.println("* byte");
                
                try { 
                	Short.parseShort( Long.toString(x) );
                    System.out.println("* short");
                } catch (Exception e ) {}
                try { 
                	Integer.parseInt( Long.toString(x) );
                    System.out.println("* int");
                } catch (Exception e )  {}
                System.out.println("* long");

                //Complete the code
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
        
         sc.close();
    }

}
