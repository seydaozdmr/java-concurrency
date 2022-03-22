package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

public class ThreadExample9 {
    public static void main(String[] args) {
        //runs forever
        Runnable r1=()->{
            while (true){
                sleep(1000);
                System.out.println("running");
            }
        };

        Thread t1=new Thread(r1);
        t1.start();
    }

    private static void sleep(long i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
