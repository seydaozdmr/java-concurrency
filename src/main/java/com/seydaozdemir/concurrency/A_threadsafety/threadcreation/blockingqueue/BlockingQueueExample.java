package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        //BlockingQueue is interface so you specified your concrete class
        BlockingQueue blockingQueue=new ArrayBlockingQueue(10);
        BlockingQueue blockingQueue1=new LinkedBlockingQueue();

        BlockingQueue<String> blockingQueue2=new ArrayBlockingQueue<>(10);

        blockingQueue2.put("element-1");
        blockingQueue2.put("element-2");

        String element1=blockingQueue2.take();
        String element2=blockingQueue2.take();

        System.out.println(element1);
        System.out.println(element2);
    }
}
