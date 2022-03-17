package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample11 {
    public static void main(String[] args) {
        Runnable r1=()->{
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("*");
            }
        };

        Thread t1=new Thread(r1);
        t1.setDaemon(true);
        t1.start();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread t2=new Thread(()->{
            System.out.println("thread 2 started.");
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread 2 ended");
        });
        t2.start();
    }
}
