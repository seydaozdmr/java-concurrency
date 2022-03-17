package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class SyncExchanger {
    private int count=0;
    private Object obj=null;
    /**
     public void set(Object obj){

        synchronized (this){
            this.count++;
            this.obj=obj;
        }
     }
     * instruction reordering may break visibility guarantee of
     * java synchronized blocks
     *
     * if two threads waiting for get lock a synchronized block, then one of them is
     * success, other one stills wait for lock. And then another new thread comes and waits for lock,
     * if first thread release lock then there is no guarantee that second thread acquire the lock.
     * Last one can get the lock. This situation named fairness.
     */

    public void set(Object obj){
        this.count++;
        synchronized (this){
            this.obj=obj;
        }
    }
    public Object get(){
        synchronized (this){
            return this.obj;
        }
    }
}
