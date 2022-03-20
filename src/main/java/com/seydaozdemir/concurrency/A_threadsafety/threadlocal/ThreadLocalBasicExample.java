package com.seydaozdemir.concurrency.A_threadsafety.threadlocal;

public class ThreadLocalBasicExample {
    ThreadLocal<String> threadLocal =new ThreadLocal<>();

    Thread t1=new Thread(()->{
        threadLocal.set("Thread - 1");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    });

    Thread t2=new Thread(()->{
        threadLocal.set("Thread -2 ");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadLocal.get());
    });

    public static void main(String[] args) {
        ThreadLocalBasicExample threadLocalBasicExample=new ThreadLocalBasicExample();
        threadLocalBasicExample.t1.start();
        threadLocalBasicExample.t2.start();
    }
}
