package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

public class ThreadExample5 {
    public static void main(String[] args) {
        Thread t1=new Thread(()-> System.out.println("my thread"));
        t1.start();
    }
}
