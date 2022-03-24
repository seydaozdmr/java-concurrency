package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer= new Consumer(blockingQueue);
        Consumer consumer1 =new Consumer(blockingQueue);

        Thread t1 = new Thread(producer);
        Thread t2=new Thread(consumer);
        Thread t3 =new Thread(consumer1);
        t1.start();
        t2.start();
        t3.start();
    }



}
