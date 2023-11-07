package com.brianc.testRepo.threading;

import java.text.SimpleDateFormat;
import java.util.Random;

class ThreadLocalRunnable implements Runnable {

    // SimpleDateFormat is not thread-safe, so give one to each thread
	// Pre-Java8
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
    	@Override
        protected SimpleDateFormat initialValue() { return new SimpleDateFormat("yyyyMMdd HHmm");}
    };

	@Override
	public void run() {

		System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        
		try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
	}
}

class ThreadLocalJava8Runnable implements Runnable {

    // SimpleDateFormat is not thread-safe, so give one to each thread
	// Pre-Java8
	private static final ThreadLocal<SimpleDateFormat> formatterJava8 = 
    		ThreadLocal.<SimpleDateFormat> withInitial
    		(() -> {return new SimpleDateFormat("yyyyMMdd HHmm");});

	@Override
	public void run() {

		System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatterJava8.get().toPattern());
        
		try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
		formatterJava8.set( new SimpleDateFormat() );
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = " + formatterJava8.get().toPattern());
	}
}

public class ThreadLocalService {


	public static void main(String[] args) throws InterruptedException {
		   
    	for(int i=0 ; i<10; i++){
    		ThreadLocalRunnable threadLocalRunnable = new ThreadLocalRunnable();
    		Thread t = new Thread( threadLocalRunnable, "" + i );
    		Thread.sleep( new Random().nextInt(1000));
    		t.start();
    		//t.join();
    	}	
    	
    	for(int i=10 ; i<20; i++){
    		ThreadLocalJava8Runnable threadLocalJava8Runnable = new ThreadLocalJava8Runnable();
    		Thread t1 = new Thread( threadLocalJava8Runnable, "" + i );
    		Thread.sleep( new Random().nextInt(1000));
    		t1.start();
    		//t1.join();
    	}
    }

	   
}
