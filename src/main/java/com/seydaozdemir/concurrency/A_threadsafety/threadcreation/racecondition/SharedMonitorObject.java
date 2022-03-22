package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class SharedMonitorObject {
    private Object monitor=null;
    private int counter=0;
    public SharedMonitorObject(Object o){
        if(o==null){
            throw new IllegalArgumentException();
        }
        this.monitor=o;
    }

    public void increment(){
        synchronized (monitor){
            this.counter++;
        }
    }


}
