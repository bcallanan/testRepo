package com.brianc.testRepo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class addemSeries {

    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int seriesNum = 1;
            int sum = 0;
            sum = sum + a + (seriesNum * b );
            System.out.print( sum);

            for ( int j = 2; j <= n; j++) {
            
                seriesNum = seriesNum * 2;

                sum = sum + (seriesNum * b );
                
                System.out.print( " " + sum);
                
            }
            System.out.println();
        }
        
         in.close();
    }

}
