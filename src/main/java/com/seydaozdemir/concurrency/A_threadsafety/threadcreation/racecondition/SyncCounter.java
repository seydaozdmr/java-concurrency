package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class SyncCounter {
    private int counter;

    public synchronized void increment(){
        this.counter++;
    }

    public int getCounter(){
        return this.counter;
    }

    public static void main(String[] args) {
        SyncCounter syncCounter=new SyncCounter();

        Thread t1= new Thread(()->{
            for(int i=0;i<1_000_000;i++){
                syncCounter.increment();
            }
            System.out.println(syncCounter.getCounter());
        });

        Thread t2=new Thread(()->{
            for(int i =0;i<1_000_000;i++){
                syncCounter.increment();
            }
            System.out.println(syncCounter.getCounter());
        });

        t1.start();
        t2.start();
    }
}
