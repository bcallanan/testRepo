package com.brianc.testRepo.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        System.out.println( runnable.toString() + " is rejected");
    }
}

class ExecuterMonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    public ExecuterMonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.seconds = delay;
    }
    
    public void shutdown() {
        this.run = false;
    }
    
    @Override
    public void run() {
    	while( run ) {
    		
    		System.out.println( String.format( "[monitor thread] [%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
			 		this.executor.getCorePoolSize(),
					this.executor.getActiveCount(),
					this.executor.getCompletedTaskCount(),
					this.executor.getTaskCount(),
					this.executor.isShutdown(),
					this.executor.isTerminated()));
    		
    		try {
    			Thread.sleep(seconds*1000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }
    }
}

class ExecutorWorkerThread implements Runnable {
	  
    private String command;
    
    public ExecutorWorkerThread(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.");
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return this.command;
    }
}

public class ExecutorThreadService {

	public static void main(String[] args) throws InterruptedException {
		    
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 10; i++) {
			Runnable worker = new ExecutorWorkerThread( "" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) { 
			Thread.sleep( 1000 );
		}
		System.out.println("Finished all threads");
		
		
		System.out.println("Starting rejection threads");

        //RejectedExecutionHandler implementation
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        //Get the ThreadFactory implementation to use
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        //creating the ThreadPoolExecutor
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
        //start the monitoring thread
        ExecuterMonitorThread monitorThreadRunnable = new ExecuterMonitorThread(executorPool, 3);
        Thread monitorThread = new Thread( monitorThreadRunnable );
        monitorThread.start();
        //submit work to the thread pool
        for(int i=0; i<20; i++){
            executorPool.execute( new ExecutorWorkerThread("cmd"+i));
        }
        
        Thread.sleep(30000);
        //shut down the pool
        executorPool.shutdown();
        //shut down the monitor thread
        Thread.sleep(5000);
        monitorThreadRunnable.shutdown();

	}
}
