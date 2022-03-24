package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMethods {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

        //put() will block until there is space
        // inside the Blocking Queue for element
        try {
            blockingQueue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //add will throw IllegalStateException if
        //no space available in Blocking Queue
        try{
            blockingQueue.add("2");
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        //offer() returns false if no space
        boolean result = blockingQueue.offer("3");

        //offer(o , time, TimeUnit) blocks for time if no space
        //then returns false if still no space
        try{
            boolean result2 = blockingQueue.offer("3", 1000, TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }
}
