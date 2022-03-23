package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceExample6 {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Future future = executorService.submit(()-> Thread.currentThread().getName()+ " : "+ "my Task");

        future.cancel(true);

        try{
            String result= (String) future.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException ignored) {

        }catch (CancellationException e){
            String message= "Cannot call Future.get() since task was cancelled";
            System.out.println(message);
        }
        System.out.println(future.isCancelled());
        executorService.shutdown();
    }
}
