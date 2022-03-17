package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample3 {
    public static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("my thread");
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread t1=new Thread(myThread);
        t1.start();
    }
}
