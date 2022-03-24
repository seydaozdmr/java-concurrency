package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample2 {
    public static void main(String[] args) {
        BlockingQueue<String> data= new ArrayBlockingQueue<>(10);
        List<String> countries= List.of("Turkey","US","UK","China","India","Belgium","France");

        Thread t1=new Thread(addElement(data,countries));
        Thread t2=new Thread(takeElement(data));
        Thread t3=new Thread(takeElement(data));

        t1.start();
        t2.start();
        t3.start();

    }
    private static Runnable addElement(BlockingQueue blockingQueue,List<String> list){
        return ()->{
            try {
                for(String e:list){
                    Thread.sleep(2000);
                    blockingQueue.put(e);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private static Runnable takeElement(BlockingQueue blockingQueue){
        return ()->{
            try{
                while(true){
                    Thread.sleep(1000);
                    String result = (String) blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+ " : " + result);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
