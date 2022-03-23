package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable2TimeOut implements Runnable{
    private Lock lock1;
    private Lock lock2;

    public Runnable2TimeOut(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        while(true){
            int failureCount=0;
            while(!tryLockBothThreads()){
                failureCount++;
                System.out.println(threadName + "failed to lock both locks. " +
                        " Waiting a bit before retrying ["+ failureCount+"] tries");
                sleep(100 + ((long)Math.random()));
            }
            if(failureCount>0){
                System.out.println(threadName + " succeeded in locking both locks - after "+
                        +failureCount+ " failures.");
            }
            lock2.unlock();
            lock1.unlock();
        }

    }

    private void sleep(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean tryLockBothThreads() {
        String threadName=Thread.currentThread().getName();
        try{
            boolean tryLock2=lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!tryLock2)
                return false;
        }catch (InterruptedException e){
            System.out.println(threadName +" Interrupted trying lock Lock-2");
            lock2.unlock();
            return false;
        }

        try{
            boolean tryLock1=lock1.tryLock(1000,TimeUnit.MILLISECONDS);
            if(!tryLock1){
                lock2.unlock();
                return false;
            }
        }catch (InterruptedException e){
            System.out.println(threadName + " Interrupted trying lock Lock-1");
            lock1.unlock();
            return false;
        }
        return true;
    }
}
