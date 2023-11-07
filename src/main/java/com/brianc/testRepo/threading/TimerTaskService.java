package com.brianc.testRepo.threading;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

class MyTimerTask extends TimerTask{

    AtomicInteger count = new AtomicInteger();
    
    @Override
    public void run() {
        System.out.println("Timer task started at:" + new Date());
        completeTimerTask();
        System.out.println("Timer task finished at:" + new Date());
    }

    public int getCount() {
        return this.count.get();
    }

    private void completeTimerTask() {
        //assuming it takes 20 secs to complete the task
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }

public class TimerTaskService {

	public static void main(String[] args) throws InterruptedException {
		    
		TimerTask timerTask = new MyTimerTask();
		//running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate( timerTask, 0, 10*1000);
		System.out.println("TimerTask started");
		//cancel after sometime
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();
		System.out.println("TimerTask cancelled");
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
