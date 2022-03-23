package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample4 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        List<Callable<String>> callables=new ArrayList<>();

        callables.add(newCallable("Task-1"));
        callables.add(newCallable("Task-2"));
        callables.add(newCallable("Task-3"));

        try{
            String result = (String) executorService.invokeAny((Collection) callables);

            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallable(String s) {
        return ()-> Thread.currentThread().getName()+ " : "+s;
    }

}
