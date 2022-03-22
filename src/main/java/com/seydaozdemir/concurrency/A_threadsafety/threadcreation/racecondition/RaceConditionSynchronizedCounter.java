package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class RaceConditionSynchronizedCounter {
    public static void main(String[] args) {

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        Thread t1=new Thread(incrementCounter(synchronizedCounter,"Thread -1 is inc"));
        Thread t2=new Thread(getReadingRunnable(synchronizedCounter,"Thread 2 is reading"));

        t1.start();
        t2.start();


    }

    public static Runnable incrementCounter(SynchronizedCounter synchronizedCounter
                                                ,String message){
        return ()->{
            for(int i=0;i<1_000_000;i++){
                synchronizedCounter.incrementAndGet();
            }
            System.out.println(message+ " "+synchronizedCounter.get());
        };
    }

    public static Runnable getReadingRunnable(SynchronizedCounter synchronizedCounter
                                                ,String message){
        return ()->{
            for(int i=0;i<5;i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message+" "+ synchronizedCounter.get());
            }
        };
    }
}
