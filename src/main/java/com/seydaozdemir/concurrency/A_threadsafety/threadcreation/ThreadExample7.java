package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample7 {
    public static void main(String[] args) {
        Runnable r1=()->{
            System.out.println("thread is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread ending");
        };
        Thread t1=new Thread(r1);
        t1.start();
    }
}
