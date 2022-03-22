package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

import com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition.MyRunnable;

public class ThreadExample12 {
    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        MyRunnable myRunnable2=new MyRunnable();
        Thread t1=new Thread(myRunnable);
        Thread t2=new Thread(myRunnable);

        t1.start();
        t2.start();
    }
}
