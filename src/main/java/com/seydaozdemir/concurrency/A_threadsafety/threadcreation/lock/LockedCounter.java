package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedCounter {
    private long counter;
    private Lock lock=new ReentrantLock();

    public void inc(){
        try{
            lock.lock();
            counter++;
        }finally {
            lock.unlock();
        }
    }

    public long getCounter(){
        try{
            lock.lock();
            return counter;
        }finally {
            lock.unlock();
        }
    }
}
