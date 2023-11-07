package com.brianc.testRepo.threading;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyLockStringRunnable implements Runnable{

	private final Lock queueLock = new ReentrantLock();
	
    String[] strArray = null;
	Object obj = new Object();

    public MyLockStringRunnable(String[] strArray) {
    	this.strArray = strArray;
    }

	@Override
    public void run() {
		processName( Thread.currentThread().getName());
    }

    public String[] getStrArray() {
		return strArray;
	}

	private void processName( String name) {

		for(int i=0; i < strArray.length; i++){
			//process data and append thread name
			processSomething(i);
			addThreadName(i, name);
		}
	}

	private void addThreadName(int i, String name) {
		queueLock.lock();
	      try {
				strArray[i] = strArray[i] + ":" + name;

	      } finally {
	          System.out.printf(
	             "%s printed the document successfully.\n", name );
	          queueLock.unlock();
	       }
		
//		synchronized( obj ) {
//			strArray[i] = strArray[i] + ":" + name;
//		}
	}

	private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep( i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
 }

public class LockStringThreadService {

	   public static void main(String[] args) throws InterruptedException {
		   
	        String[] arr = {"1","2","3","4","5","6"};
	        MyLockStringRunnable stringRunnable= new MyLockStringRunnable( arr);
	        
	        Thread t1=new Thread( stringRunnable, "t1");
	        Thread t2=new Thread( stringRunnable, "t2");
	        Thread t3=new Thread( stringRunnable, "t3");
	        long start = System.currentTimeMillis();
	        
	        //start all the threads
	        t1.start();t2.start();t3.start();
	        
	        //wait for threads to finish
	        t1.join();t2.join();t3.join();
	        
	        System.out.println("Time taken= "+(System.currentTimeMillis()-start));
	        //check the shared variable value now
	        System.out.println(Arrays.asList( stringRunnable.getStrArray() ));
	    }
}
