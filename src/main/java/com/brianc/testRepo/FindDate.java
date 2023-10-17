package com.brianc.testRepo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class FindDate {
	
    public static String findDay(int month, int day, int year) {


        String pattern = "EEEEE";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", java.util.Locale.US);  //pattern);
        
        Date d = null;
		try {
			d = simpleDateFormat.parse( month + "/" + day + "/" + year );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        simpleDateFormat.applyPattern(pattern);
        String date = simpleDateFormat.format( d );
        return date.toUpperCase();
    }

    public static void main(String[] args) throws IOException {
    	
    	
    	
    	System.out.println( findDay( 10, 16, 2023) );
    }
}
