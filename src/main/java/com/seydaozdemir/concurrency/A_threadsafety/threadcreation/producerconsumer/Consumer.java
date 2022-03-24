package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer <T> implements Runnable {
    private BlockingQueue<T> blockingQueue;

    public Consumer(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true){
            try{
                String message= (String) blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+ " consumed : "+ message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sleep(100);
        }

    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
