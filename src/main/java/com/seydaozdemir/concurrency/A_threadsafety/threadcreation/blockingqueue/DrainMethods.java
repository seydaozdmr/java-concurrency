package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DrainMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);

        Collection dest= new ArrayList();

        //will drain all the elements from the blocking queue into this dest
        blockingQueue.drainTo(dest);

        //drain up to 5 elements to dest
        blockingQueue.drainTo(dest,5);
    }
}
