package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample3 {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);
        List<String> countries= List.of("Turkey","US","UK","China","India","Belgium","France","Nigeria"
                ,"Greek","Ukraine","Poland","Italy","Spain","Japan");
        List<String> capitals= List.of("Ankara","Washington","London","Beijing","New Delhi","Brussels","Paris","Abuja"
                ,"Athens","Kiev","Warsaw","Roma","Madrid","Tokyo");
        Producer<String> producer=new Producer<>(blockingQueue,countries);
        Consumer<String> consumer=new Consumer<>(blockingQueue);
        Producer<String> producer1=new Producer<>(blockingQueue,capitals);

        Thread t1=new Thread(producer);
        Thread t2=new Thread(producer1);
        Thread t3=new Thread(consumer);
        Thread t4=new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
