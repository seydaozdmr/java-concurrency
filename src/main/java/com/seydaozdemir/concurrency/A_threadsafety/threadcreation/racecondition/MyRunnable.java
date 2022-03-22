package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

import java.util.Objects;

public class MyRunnable implements Runnable{
    //count lives in heap if two different threads use same MyRunnable object,
    // each of them use same count
    private int count;

    @Override
    public void run() {
        //local variables (i) never shared between threads
        for(int i=0;i<1_000_000;i++) {
            this.count++;
        }
        System.out.println(Thread.currentThread().getName() + " : "+this.count);
        /**
         * If we create an object in run() method, each threads create an new Objects in heap
         * and each threads create a reference in own thread stack.
         */
        Object object=new Object();
        System.out.println(object.toString());
    }
}
