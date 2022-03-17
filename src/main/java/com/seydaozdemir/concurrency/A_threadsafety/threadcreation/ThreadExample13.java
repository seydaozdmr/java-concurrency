package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample13 {

    public static void main(String[] args) {
        MyObject myObject=new MyObject("test");

        MyRunnableSharedObject myRunnableSharedObject=new MyRunnableSharedObject(myObject);
        MyRunnableSharedObject myRunnableSharedObject1=new MyRunnableSharedObject(myObject);

        Thread thread=new Thread(myRunnableSharedObject);
        thread.start();
        Thread thread1=new Thread(myRunnableSharedObject1);
        thread1.start();
    }
}
