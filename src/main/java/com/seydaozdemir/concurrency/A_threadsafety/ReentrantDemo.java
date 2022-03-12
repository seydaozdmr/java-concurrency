package com.seydaozdemir.concurrency.A_threadsafety;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class ReentrantDemo {
    public static void main(String[] args) {
        ReentrantDemo reentrantDemo=new ReentrantDemo();

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 before call "+ LocalDateTime.now());
            reentrantDemo.syncMethod1("from thread1");
            System.out.println("thread1 after call "+LocalDateTime.now());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 before call "+LocalDateTime.now());
            reentrantDemo.syncMethod1("from thread2");
            System.out.println("thread2 after call "+LocalDateTime.now());
        });

        thread1.start();
        thread2.start();
    }

    private synchronized void syncMethod1 (String msg) {
        System.out.println("in the syncMethod1 "+msg+" "+ LocalDateTime.now());
        syncMethod2("from method syncMethod1, reentered call thread: "+ msg);
        System.out.println("out of "+msg);
    }

    /**
     * ikinci method synchronized olmasa bile syncMethod1 lock'u aldığında işlem bitene kadar
     * başka bir thread'e lock'u vermez.
     */
    private void syncMethod2 (String msg) {
        System.out.println("in the syncMethod2 "+msg+" "+LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
