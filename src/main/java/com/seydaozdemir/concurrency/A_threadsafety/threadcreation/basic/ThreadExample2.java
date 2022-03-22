package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

public class ThreadExample2 {
    private class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("my thread");
        }
    }
    static class MynewThread extends Thread{
        @Override
        public void run(){
            System.out.println("static class");
        }
    }

    public static void main(String[] args) {
        ThreadExample2 threadExample2 = new ThreadExample2();
        ThreadExample2.MyThread myThread = threadExample2.new MyThread();

        MynewThread mynewThread=new MynewThread();

        myThread.start();
        mynewThread.start();


    }
}
