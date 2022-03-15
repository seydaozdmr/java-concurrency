package com.seydaozdemir.concurrency.C_composingobjects;

import java.util.Vector;

public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E x){
        boolean absent = !contains(x);
        if (absent){
            this.add(x);
        }
        return absent;
    }
}
