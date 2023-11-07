package com.brianc.testRepo.threading;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerConsumerMessage {
    private String msg;
    public ProducerConsumerMessage(String str) { this.msg=str; }
    public String getMsg() { return msg; }
}

class Consumer implements Runnable{

	private BlockingQueue< ProducerConsumerMessage > queue;
    
    public Consumer( BlockingQueue< ProducerConsumerMessage > q ){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            ProducerConsumerMessage msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getMsg() !="exit"){
            Thread.sleep(10);
            System.out.println("Consumed "+msg.getMsg());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {

    private BlockingQueue<ProducerConsumerMessage> queue;
    
    public Producer( BlockingQueue< ProducerConsumerMessage > queue){

    	this.queue=queue;
    }
    @Override
    public void run() {
        //produce messages
        for(int i=0; i<100; i++){
            ProducerConsumerMessage msg = new ProducerConsumerMessage( "" + i);
            try {
                Thread.sleep(i);
                queue.put(msg);
                System.out.println("Produced "+msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        ProducerConsumerMessage msg = new ProducerConsumerMessage("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumerBlockingQueueService {

     public static void main(String[] args) throws IOException {
        
    	 //Creating BlockingQueue of size 10
    	 BlockingQueue<ProducerConsumerMessage> queue = new ArrayBlockingQueue<>(10);
         
    	 Producer producer = new Producer(queue);
         Consumer consumer = new Consumer(queue);
         
         //starting producer to produce messages in queue
         new Thread(producer).start();
         //starting consumer to consume messages from queue
         new Thread(consumer).start();
         System.out.println("Producer and Consumer has been started");
   }
}
