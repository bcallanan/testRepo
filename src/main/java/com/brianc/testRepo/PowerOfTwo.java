package com.brianc.testRepo;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class PowerOfTwo {
	

    public static void main(String[] args) throws IOException {
    	
    	try {
			int num = 7;

       		PowerOfTwo.Inner i = new Inner();
       		PowerOfTwo.Inner.Private o = i.new Private();
  
           //((Solution.Inner.Private) o).powerof2( num );
       		System.out.println( num + " is " + ((PowerOfTwo.Inner.Private) o).powerof2( num ) );

    		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
 		}
		
		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
    
    
	static class Inner {
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner
	
}//end of Solution

