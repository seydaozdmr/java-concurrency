package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

import com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition.MyRunnableSharedInteger;

public class ThreadExample14 {
    public static void main(String[] args) {
        Integer i= 1;

        MyRunnableSharedInteger myRunnableSharedInteger = new MyRunnableSharedInteger(i);
        MyRunnableSharedInteger myRunnableSharedInteger1 = new MyRunnableSharedInteger(i);

        Thread t1 = new Thread(myRunnableSharedInteger);
        Thread t2 = new Thread(myRunnableSharedInteger1);
        t1.start();
        t2.start();
    }
}
