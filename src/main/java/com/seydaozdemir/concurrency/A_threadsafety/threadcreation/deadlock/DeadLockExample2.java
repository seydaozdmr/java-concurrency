package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample2 {
    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();

        RunnableSync1 runnableSync1=new RunnableSync1(lock1,lock2);
        RunnableSync2 runnableSync2 =new RunnableSync2(lock1,lock2);

        Thread t1=new Thread(runnableSync1);
        Thread t2=new Thread(runnableSync2);

        t1.start();
        t2.start();
    }
}
