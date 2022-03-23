package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTimeOutExample {
    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();

        Runnable1TimeOut runnable1TimeOut=new Runnable1TimeOut(lock1,lock2 );
        Runnable2TimeOut runnable2TimeOut=new Runnable2TimeOut(lock1,lock2);

        Thread t1=new Thread(runnable1TimeOut);
        Thread t2=new Thread(runnable2TimeOut);

        t1.start();
        t2.start();
    }
}
