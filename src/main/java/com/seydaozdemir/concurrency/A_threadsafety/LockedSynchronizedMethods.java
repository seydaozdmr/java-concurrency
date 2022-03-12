package com.seydaozdemir.concurrency.A_threadsafety;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class LockedSynchronizedMethods {

    public static void main(String[] args) {
        LockedSynchronizedMethods lockedSynchronizedMethods=new LockedSynchronizedMethods();
        Thread t1=new Thread(()->{
            System.out.println("Thread-1 is calling method1");
            lockedSynchronizedMethods.syncMethod1("Thread-1 started");
            System.out.println("Thread-1 out of method");
        });

        Thread t2=new Thread(()->{
            System.out.println("Thread-2 is calling method2");
            lockedSynchronizedMethods.syncMethod2("Thread-2 started");
            System.out.println("Thread-2 out of method");
        });
        t1.start();
        t2.start();
    }

    /**
     * No thread executing a synchronized block can
     * observe another thread to be in the middle of a
     * synchronized block guarded by the same lock.
     */
    private synchronized void syncMethod1 (String msg) {
        System.out.println("in the syncMethod1 "+msg+" "+ LocalDateTime.now());
        syncMethod2("from method syncMethod1, reentered call method2 thread: "+ msg);
        System.out.println("out of "+msg);
    }

    private synchronized void syncMethod2 (String msg) {
        System.out.println("in the syncMethod2 "+msg+" "+LocalDateTime.now());
        try {
            for(int i=0;i<10;i++){
                System.out.println(msg+" is in " + i);
            }
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
