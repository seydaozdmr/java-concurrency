package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.compareandswap;

import java.util.concurrent.atomic.AtomicLong;

public class OptimisticLockCounter {
    private AtomicLong atomicLong=new AtomicLong();

    public void inc(){
        boolean isSuccess=false;
        while(!isSuccess){
            long value=atomicLong.get();
            long newValue=value+1;

            isSuccess=atomicLong.compareAndSet(value,newValue);
        }
    }

    public long get(){
        return this.atomicLong.get();
    }
}
