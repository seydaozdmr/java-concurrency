package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.blockingqueue;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PeekMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(10);

        //look at the first element of queue without removing it.
        String element= blockingQueue.peek();

        try{
            //if there is no element in queue, the element will thrown NoSuchElementException
            String firstElement=blockingQueue.element();
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
