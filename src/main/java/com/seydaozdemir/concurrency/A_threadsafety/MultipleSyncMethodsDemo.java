package com.seydaozdemir.concurrency.A_threadsafety;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MultipleSyncMethodsDemo {
    public static void main(String[] args) {
        MultipleSyncMethodsDemo demo= new MultipleSyncMethodsDemo();

        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 before call "+ LocalDateTime.now());
            demo.syncMethod1("from thread1");
            System.out.println("thread1 after call "+LocalDateTime.now());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 before call "+LocalDateTime.now());
            demo.syncMethod2("from thread2");
            System.out.println("thread2 after call "+LocalDateTime.now());
        });

        thread1.start();
        thread2.start();
    }

    /**
     *Thread1 ya da Thread2 synchronized methodları çağırdığı zaman
     * herhangi biri methodun içindeyken o thread lock'u elde eder ve işlem bitene kadar diğer
     * thread diğer methodun içine giremez çünkü Intrinsic lock is on object, not on a method.
     * synchronized kullanılan method içindeki nesneyi lock olarak kullanır. Ve işlem bitene kadar
     * bu lock'u bırakmaz.
     */

    private synchronized void syncMethod1 (String msg) {
        System.out.println("in the syncMethod1 "+msg+" "+LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void syncMethod2 (String msg) {
        System.out.println("in the syncMethod2 "+msg+" "+ LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
