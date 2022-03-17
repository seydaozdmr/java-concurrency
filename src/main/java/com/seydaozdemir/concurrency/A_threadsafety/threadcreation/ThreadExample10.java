package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample10 {
    //daemon threads
    public static void main(String[] args) {
        Runnable r1=()->{
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("*");
            }
        };
        Thread t1=new Thread(r1);
        t1.setDaemon(true);
        t1.start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
