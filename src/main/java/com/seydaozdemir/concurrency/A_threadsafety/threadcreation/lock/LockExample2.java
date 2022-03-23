package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample2 {

    public static void main(String[] args) {
        lockBasics();
    }

    private static void lockBasics() {
        //false -> fairness
        // çok fazla thread kullanmıyorsanız fairness'i garanti etmenize gerek yok.
        Lock lock=new ReentrantLock(false);

        Runnable runnable=()->{lockSleepUnlock(lock,3000);};

        Thread t1=new Thread(runnable,"Thread -1 ");
        Thread t2=new Thread(runnable, "Thread -2");
        Thread t3=new Thread(runnable,"Thread -3");

        Thread t4=new Thread(()->sleep(4000),"Thread -4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    private static void lockSleepUnlock(Lock lock, long i) {
        try{
            lock.lock();
            printMessage(" holds the lock;");
            sleep(i);
        }finally {
            lock.unlock();
        }
    }

    private static void sleep(long i) {
        //burada lock olmadığı için başka bir thread de aynı anda bu noktaya girebilir.
        try {
            printMessage("Sleeping : "+Thread.currentThread().getName());
            Thread.sleep(i);
            printMessage("End of sleep :"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printMessage(String s) {
        System.out.println(Thread.currentThread().getName()+ s);
    }
    
    private static void lockInterruptibility(){
        Lock lock=new ReentrantLock();
        Thread.currentThread().interrupt();
        try{
            lock.lockInterruptibly();
            lock.unlock();
        }catch (InterruptedException e){
            System.out.println("Thread interrupted..");
        }
    }

    private void tryLock(){
        Lock lock=new ReentrantLock();
        try{
            //lock'u almak için belirli bir zaman koşulu koyabiliriz. lock.tryLock(1000,TimeUnit.MILLISECONDS)
            // lock'u almak için 1 saniye bekler. Bu sürede alamazsa false döner.
            boolean lockSuccessful = lock.tryLock();
            System.out.println("Lock successful : "+lockSuccessful );
        }finally {
            lock.unlock();
        }
    }


}
