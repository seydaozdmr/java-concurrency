package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();

        lock.lock();
        System.out.println(Thread.currentThread().getName());

        lock.unlock();
    }
}
