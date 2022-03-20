package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class ThreadExample3 {
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("my thread");
        }
    }
    public static class Asansor implements Runnable{
        int kat=0;
        @Override
        public void run() {
            kat++;
            System.out.println(kat);
        }
    }

    public static void main(String[] args) {
        MyRunnable myThread=new MyRunnable();
        Thread t1=new Thread(myThread);
        t1.start();

        Thread t2=new Thread(new Asansor());
        t2.start();
    }
}
