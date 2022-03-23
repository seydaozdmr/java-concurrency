package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample2 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Future future= executorService.submit(newRunnable("My Task"));

        System.out.println(future.isDone());

        try{
            future.get();
        }catch (InterruptedException | ExecutionException e){
            System.out.println(e.getMessage());
        }

        System.out.println(future.isDone());
    }

    private static Runnable newRunnable(String my_task) {
        return ()->System.out.println(Thread.currentThread().getName()+ " : "+my_task);
    }


}
