package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.concurrent.*;

public class CreatingExecutorService {
    public static void main(String[] args) {
        int corePoolSize=10;
        int maxPoolSize=20;
        long keepAliveTime=3000;

        ExecutorService executorService=new ThreadPoolExecutor(corePoolSize
        ,maxPoolSize,keepAliveTime, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(1024));

        executorService= Executors.newFixedThreadPool(3);

        ExecutorService executorService1=Executors.newScheduledThreadPool(10);

        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(corePoolSize);


    }
}
