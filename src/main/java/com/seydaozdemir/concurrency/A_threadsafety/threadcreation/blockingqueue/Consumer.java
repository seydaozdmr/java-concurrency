package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer <T> implements Runnable{
    private BlockingQueue <T> blockingQueue;

    public Consumer(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            String threadName=Thread.currentThread().getName();
            T result= null;
            try {
                result = blockingQueue.take();
                System.out.println(threadName+" : "+result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
