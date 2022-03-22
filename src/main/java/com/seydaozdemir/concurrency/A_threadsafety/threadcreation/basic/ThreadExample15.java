package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

import com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition.MyRunnable;

public class ThreadExample15 {
    public static void main(String[] args) {
        Runnable runnable=new MyRunnable();
        Runnable runnable1=new MyRunnable();

        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable1);

        t1.start();
        t2.start();
    }
}
