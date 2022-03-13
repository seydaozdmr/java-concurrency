package com.seydaozdemir.concurrency.B_sharingobjects;

public class SynchronizedInteger {
    private volatile int value;

    public int get(){
        return this.value;
    }

    public void set(int v){
        this.value=v;
    }
}
