package com.brianc.testRepo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class RegexApp 
{
    public static void main( String[] args ) {
    
        Scanner scan = new Scanner(System.in);
      Integer i = null;
      String s = null;
      Double d = null;
      while ( scan.hasNextLine()) {
          String line = scan.nextLine();
          if ( line.isEmpty() ) break;
          else if ( line.matches( "^[+,-]{0,}\\d*" ) && i == null ) {
        	  //Matches Int
              i = Integer.parseInt(line);
              continue;
          }
          else if ( line.matches( "\\d*\\.?\\d+|\\d*\\." ) && d == null) {
        	  //Matches Double
              d = Double.valueOf( line );
              continue;
          }
          else if ( line.matches( ".*\\w+[ .\\!\\']{0,}.*$" ) && s == null) {
        	  //Matches String
               s = line;
               continue;
           }
          else {
              continue;
          }
      }
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

     }
}
