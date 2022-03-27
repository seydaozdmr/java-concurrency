package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.compareandswap;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class CompareAndSwapLock {
    private AtomicBoolean atomicBoolean=new AtomicBoolean(false);

    public void unlock(){
        this.atomicBoolean.set(false);
    }

    public void lock(){
        while (!this.atomicBoolean.compareAndSet(false,true)){
            // compareAndSet başarılı olana kadar burada beklenir.
            // lock'u alan herhangi bir thread lock'u bırakana kadar bekler.
        }
    }
}
