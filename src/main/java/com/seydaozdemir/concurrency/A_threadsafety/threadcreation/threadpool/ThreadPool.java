package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    BlockingQueue<Runnable> blockingQueue;
    List<PoolThreadRunnable> poolThreadRunnables=new ArrayList<>();
    boolean isStopped=false;
    public ThreadPool(int numberOfThreads,int queueCapacity) throws InterruptedException {
        this.blockingQueue=new LinkedBlockingQueue<>(queueCapacity);
        for(int i=0;i<numberOfThreads;i++){
            poolThreadRunnables.add(new PoolThreadRunnable(blockingQueue));
        }
        for(PoolThreadRunnable runnable:poolThreadRunnables){
            new Thread(runnable).start();
        }
    }

    private static class PoolThreadRunnable implements Runnable{
        BlockingQueue<Runnable> blockingQueue;
        boolean isStopped=false;
        //Thread thread=null;
        public PoolThreadRunnable(BlockingQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            //this.thread=Thread.currentThread();
            while(!isStopped){
                if(blockingQueue.size()>0){
                    Runnable runnable = null;
                    try {
                        runnable= blockingQueue.take();
                        runnable.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void doStop(){
            this.isStopped=true;
        }
    }
    public void execute(Runnable runnable) throws InterruptedException {
        if(this.isStopped) throw
            new IllegalStateException("Threadpool is stopped");
        blockingQueue.offer(runnable);
    }
    public void waitUntilAllTasksFinished(){
        while(!blockingQueue.isEmpty()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        this.isStopped=true;
        for(PoolThreadRunnable runnable:poolThreadRunnables){
            runnable.doStop();
        }
    }
}
