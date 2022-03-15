package com.seydaozdemir.concurrency.C_composingobjects;

public class ImmutablePoint {
    public final int x;
    public final int y;

    public ImmutablePoint(int x, int y) {
        /**
         * Point is thread-safe because it is immutable.
         * Immutable values can be freely shared and published,
         * so we no longer need to copy the locations when returning them.
         */
        this.x = x;
        this.y = y;
    }
}
