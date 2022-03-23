package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable1TimeOut implements Runnable{
    private Lock lock1;
    private Lock lock2;

    public Runnable1TimeOut(Lock lock1, Lock lock2) {
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

    private boolean tryLockBothThreads() {
        String threadName= Thread.currentThread().getName();

        try{
            boolean lock1Succeed = lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!lock1Succeed)
                return false;
        }catch (InterruptedException e){
            System.out.println(threadName+ " interrupted trying to lock Lock-1");
            return false;
        }

        try{
            boolean lock2Succeed=lock2.tryLock(1000,TimeUnit.MILLISECONDS);
            if(!lock2Succeed){
                //eğer ikinci lock'ı alamazsa birinci lock'u serbest bırakıyor.
                lock1.unlock();
                return false;
            }

        }catch (InterruptedException e){
            System.out.println(threadName+ " interrupted trying to lock Lock-2");
            //hata durumunda aynı şekilde lock1'i serbest bırakıyor.
            lock2.unlock();
            return false;
        }
        return true;
    }


    private void sleep(long l) {
        try {
            Thread.sleep(l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
