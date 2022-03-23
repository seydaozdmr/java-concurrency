package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceExample3 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Future future=executorService.submit(myCallable("Test"));

        System.out.println(future.isDone());

        try{
            String result=(String) future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(future.isDone());

        executorService.shutdown();
    }

    private static Callable myCallable(String test) {
        return () -> Thread.currentThread().getName() + " : " + test;
    }
}
