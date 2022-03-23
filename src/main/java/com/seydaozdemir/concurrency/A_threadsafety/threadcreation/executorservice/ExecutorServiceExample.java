package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        executorService.execute(newRunnable("Task -1"));
        executorService.execute(newRunnable("Task -2"));
        executorService.execute(newRunnable("Task -3"));

        executorService.shutdown();
    }

    private static Runnable newRunnable(String task){
        return ()->{
            System.out.println(Thread.currentThread().getName()+ " : "+task);
        };
    }
}
