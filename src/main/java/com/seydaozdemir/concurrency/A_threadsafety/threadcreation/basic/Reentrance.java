package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

public class Reentrance {
    private int count;

    public void inc(){
        this.count++;
    }

    public synchronized int incAndGet(){
        inc();
        return this.count;
    }
}
