package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    /**
     * When two threads need two or more locks in order to do their job.
     * Each of the threads succeed in locking of the locks, but not the other. And then waiting indefinitely
     * for the other threat to release the other lock.
     */

    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();

        Runnable runnable1=new Runnable1(lock1,lock2);
        //Runnable runnable2=new Runnable2(lock1,lock2); -> caused deadlock, solution is reordering locks.
        Runnable runnable2=new Runnable2(lock2,lock1);

        Thread t1=new Thread(runnable1);
        Thread t2=new Thread(runnable2);

        t1.start();
        t2.start();

    }
}
