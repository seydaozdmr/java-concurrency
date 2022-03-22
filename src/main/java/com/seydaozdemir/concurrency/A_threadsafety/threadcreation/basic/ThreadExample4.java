package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

public class ThreadExample4 {
    static Runnable myRunnable=new Runnable() {
        @Override
        public void run() {
            System.out.println("my anonymous runnable");
        }
    };


    public static void main(String[] args) {
        Thread t1=new Thread(myRunnable);
        t1.start();
    }
}
