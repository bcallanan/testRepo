package com.brianc.testRepo;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class CurrencyByLocale {
	

    public static void main(String[] args) throws IOException {
    	
    	
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        String us  = NumberFormat.getCurrencyInstance( java.util.Locale.US ).format( payment );
        String china = NumberFormat.getCurrencyInstance( java.util.Locale.CHINA ).format( payment );
        String france = NumberFormat.getCurrencyInstance( java.util.Locale.FRANCE ).format( payment );
        String india = NumberFormat.getCurrencyInstance( new Locale( "en", "IN" )).format( payment );

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }
}
