package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.compareandswap;

public class ProblematicLock {
    private volatile boolean locked=false;

    public void unlock(){
        this.locked = false;
    }

    public void lock(){
        while(this.locked){
            //waits if some thread acquire the lock
        }
        //thread lock'u bırakınca başka bir thread locku alır
        this.locked=true;

    }
}
