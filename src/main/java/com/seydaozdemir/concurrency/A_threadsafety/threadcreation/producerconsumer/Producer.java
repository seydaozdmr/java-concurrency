package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer<T> implements Runnable {
    private BlockingQueue<T> blockingQueue;

    public Producer(BlockingQueue<T> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true)
        {
            long timeMillis = System.currentTimeMillis();
            try{
                this.blockingQueue.put((T) (""+timeMillis));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
            sleep(1000);
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
