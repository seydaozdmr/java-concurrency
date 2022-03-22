package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class Counter {
    private long count;

    public long incAndGet(){
        return this.count++;
    }

    public long get(){
        return this.count;
    }

}
