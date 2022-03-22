package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class MixedSynchronization {
    public static Object staticObj;
    //uses MixedSynchronization for lock
    public static synchronized void setStaticObj(Object o){
        staticObj = o;
    }

    public Object obj;

    //Uses instance object of MixedSynchronization for lock
    public synchronized void setObj(Object o){
        obj=o;
    }
}
