package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

import java.util.stream.IntStream;

public class MyRunnableSharedObject implements Runnable {
    private int count;
    private MyObject myObject=null;

    public MyRunnableSharedObject(MyObject myObject) {
        this.myObject = myObject;
    }


    @Override
    public void run() {
        System.out.println(myObject);

        for(int i=0;i<1_000_000;i++){
            count++;
        }
        System.out.println(Thread.currentThread().getName()+ " : "+ count);

    }
}
