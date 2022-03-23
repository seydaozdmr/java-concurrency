package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample1 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        executorService.execute(doSomething("Task-1"));
        executorService.execute(doSomething("Task-2"));
        executorService.execute(doSomething("Task-3"));

        executorService.shutdown();
    }

    private static Runnable doSomething(String message){
        return ()-> {
            System.out.println(Thread.currentThread().getName()+ " - "+message );
        };
    }
}
