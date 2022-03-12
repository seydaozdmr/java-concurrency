package com.seydaozdemir.concurrency.A_threadsafety;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ThreadLockDemo {
    public static void main(String[] args) {
        ThreadLockDemo demo=new ThreadLockDemo();
        Thread t1=new Thread(()->{
            System.out.println("thread1 before call "+ LocalDateTime.now());
            demo.syncMethod("from thread1");
            System.out.println("thread1 after call "+LocalDateTime.now());
        });
        Thread t2=new Thread(()->{
            System.out.println("thread2 before call "+ LocalDateTime.now());
            demo.syncMethod("from thread2");
            System.out.println("thread2 after call "+LocalDateTime.now());
        });

        t1.start();
        t2.start();
    }
    private synchronized void syncMethod (String msg) {
        System.out.println("in the sync method "+msg+" "+ LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


