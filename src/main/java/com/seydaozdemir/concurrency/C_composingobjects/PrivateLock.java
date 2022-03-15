package com.seydaozdemir.concurrency.C_composingobjects;

public class PrivateLock {
    private final Object myLock=new Object();

    public void doSomething(){
        synchronized (myLock){
            System.out.println("private lock");
        }
    }
}
