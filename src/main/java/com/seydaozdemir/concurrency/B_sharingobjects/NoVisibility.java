package com.seydaozdemir.concurrency.B_sharingobjects;

public class NoVisibility {
    private static int number;
    private static boolean ready = false;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while(!ready){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number=50;
        ready=true;
    }
}
