package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDequeueMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);

        // take() blocks until an element becomes available
        try{
            String element =blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //pool() returns null if no element is available
        String element1=blockingQueue.poll();

        //pool(long timeOut, TimeUnit timeUnit) blocks up until timeout
        //for an element to become available. If no element is available before that time
        //null is returned.
        try{
            String element3= blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //removes the element if present in the BlockingQueue
        //if presents more than one, removes the first element
        boolean wasRemoved = blockingQueue.remove("1");



    }
}
