package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t1=new Thread(()->System.out.println("merhaba"));
        t1.start();
    }
}
