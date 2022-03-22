package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class SynchronizedCounter {
    private long count;

    public long incrementAndGet(){
        synchronized (this){
            return this.count++;
        }
    }

    public long get(){
        synchronized (this){
            return this.count;
        }
    }
}
