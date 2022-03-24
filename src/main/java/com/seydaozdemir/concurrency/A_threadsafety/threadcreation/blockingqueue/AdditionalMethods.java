package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AdditionalMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);
        //size of element inside the blocking queue
        int size=blockingQueue.size();

        //returns the number of elements remains that the blocking queue has space to store still
        int capacity=blockingQueue.remainingCapacity();

        //return true or false depending on whether the blocking queue has the given element stored
        // or has element matches this element that you pass here as parameter
        boolean containsElement = blockingQueue.contains("1");

    }
}
