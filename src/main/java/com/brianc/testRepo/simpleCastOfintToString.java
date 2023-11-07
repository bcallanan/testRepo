package com.brianc.testRepo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class simpleCastOfintToString {


    public static void main(String []argh){

    	  DoNotTerminate.forbidExit();
    	  Scanner in = null;
    	  try {
    		   //Scanner in = new Scanner(System.in);
    		   int n = in .nextInt();
    		   in.close();
    		  
    		  String s = null;
    		  in = new Scanner(System.in);
    		  while ( in.hasNext() ) {
    			  try {
    				  s = in.next();
    				  int fooInt = Integer.parseInt(s);
    				  if ( fooInt >= -100  && fooInt <= 100 ) {
    					  System.out.println("Good job");
    				  }
    				  else { 
    					  throw new Exception();
    				  }
    			  } catch (Exception e ) {
    				  System.out.println("Wrong answer.");
    			  }
	    	  }
    	  } catch (DoNotTerminate.ExitTrappedException e) {
    		  System.out.println("Unsuccessful Termination!!");
    	  }
    	  in.close();
    }
}
