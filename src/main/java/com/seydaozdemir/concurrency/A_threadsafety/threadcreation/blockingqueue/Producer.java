package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer <T> implements Runnable{
    private BlockingQueue<T> blockingQueue;
    private List<T> list;

    public Producer(BlockingQueue<T> blockingQueue,List<T> list) {
        this.blockingQueue = blockingQueue;
        this.list=list;
    }

    @Override
    public void run() {
        int start=0;
        while(list.size()>start){
            try {
                Thread.sleep(1000);
                blockingQueue.put(list.get(start++));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
