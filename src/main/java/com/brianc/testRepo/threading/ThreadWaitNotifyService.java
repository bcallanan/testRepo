package com.brianc.testRepo.threading;


class ThreadWaiterMessage {
    private String msg;
    public ThreadWaiterMessage(String str) { this.msg=str; }
    public String getMsg() { return msg; }
    public void setMsg(String str) { this.msg=str; }

}

class ThreaderNotifierRunnable implements Runnable {

    private ThreadWaiterMessage msg;
    public ThreaderNotifierRunnable(ThreadWaiterMessage msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
                //msg.notify();        // <<<<<<<<<<<
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
class ThreadWaiterRunnable implements Runnable{
    private ThreadWaiterMessage msg;
    
    public ThreadWaiterRunnable( ThreadWaiterMessage m){
        this.msg=m;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg) {
            try{
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: "+msg.getMsg());
        }
    }

}
public class ThreadWaitNotifyService {

	public static void main(String[] args) {
		ThreadWaiterMessage msg = new ThreadWaiterMessage("process it");
		ThreadWaiterRunnable waiter = new ThreadWaiterRunnable(msg);
        new Thread(waiter,"waiter").start();
        
        ThreadWaiterRunnable waiter1 = new ThreadWaiterRunnable(msg);
        new Thread(waiter1, "waiter1").start();
        
        ThreaderNotifierRunnable notifier = new ThreaderNotifierRunnable(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
	}
}
