package com.seydaozdemir.concurrency.C_composingobjects;

/**
 * Counter in Listing 4.1 shows a typical example of this pattern.
 * It encapsulates one state variable, value,
 * all access to that state variable is through the methods of Counter, which are all synchronized.
 */
public class ThreadSafeCounter {
    /**
     * Simple Thread-safe Counter Using the Java Monitor Pattern.
     */
    private long value;

    public synchronized long getValue(){
        return this.value;
    }

    public synchronized long increment(){
        if(value==Long.MAX_VALUE)
            throw new IllegalStateException("counter overflow");
        return ++value;
    }
}
