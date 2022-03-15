package com.seydaozdemir.concurrency.C_composingobjects;

public class MutablePoint {
    int x;
    int y;

    public MutablePoint(MutablePoint mutablePoint) {
        this.x=mutablePoint.x;
        this.y=mutablePoint.y;
    }

    public MutablePoint() {
    }
}
