package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.deadlock;

import java.util.concurrent.locks.Lock;

public class RunnableSync1 implements Runnable{
    private Lock lock1;
    private Lock lock2;

    public RunnableSync1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName= Thread.currentThread().getName();

        System.out.println(threadName + " attempting to lock Lock - 1 ");
        synchronized (lock1){
            System.out.println(threadName + " locked Lock-1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " attempting to lock Lock - 2");
            synchronized (lock2){
                System.out.println(threadName + " locked Lock-2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " unlocking Lock-2");
        }
        System.out.println(threadName+ " unlocking Lock-1");
    }
}
