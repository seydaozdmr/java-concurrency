package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.threadpool;

public class ThreadPoolExample {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool=new ThreadPool(3,10);

        for(int i=0;i<10;i++){
            int taskNo=i;
            threadPool.execute(()->{
                String message=Thread.currentThread().getName()+" : Task "+taskNo;
                System.out.println(message);
            });
        }

        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();

    }
}
