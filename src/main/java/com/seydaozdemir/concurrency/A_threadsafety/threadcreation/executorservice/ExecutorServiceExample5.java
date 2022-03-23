package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample5 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        List<Callable<String>> callables=new ArrayList<>();

        callables.add(newCallable("Task-1"));
        callables.add(newCallable("Task-2"));
        callables.add(newCallable("Task-3"));

        try{
            List<Future<String>> result = executorService.invokeAll((Collection) callables);
            for(Future<String> future:result){
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallable(String s) {
        return ()-> Thread.currentThread().getName()+ " : "+s;
    }
}
