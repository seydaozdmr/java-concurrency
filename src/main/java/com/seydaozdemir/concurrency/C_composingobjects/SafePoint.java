package com.seydaozdemir.concurrency.C_composingobjects;

public class SafePoint {
    private int x;
    private int y;

    private SafePoint(int[] arr){
        /**
         * The private constructor exists to avoid the race condition that would occur
         * if the copy constructor were implemented as this(p.x, p.y);
         * this is an example of the private constructor capture idiom
         */
        this(arr[0],arr[1]);
    }
    public SafePoint (SafePoint p){
        this(p.get());
    }

    public SafePoint(int x,int y){
        this.x=x;
        this.y=y;
    }

    public synchronized int[] get(){
        return new int[] {this.x, this.y};
    }
    public synchronized void set(int x,int y){
        this.x=x;
        this.y=y;
    }


}
