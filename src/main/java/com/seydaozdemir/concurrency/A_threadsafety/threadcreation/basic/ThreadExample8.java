package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.basic;

public class ThreadExample8 {
    public static class StoppableRunnable implements Runnable{
        private boolean stopRequest=false;
        private Object object=new Object();

        public void requestStop(){
            synchronized (object){
                this.stopRequest=true;
            }
        }

        public boolean isStopRequested(){
            synchronized (object){
                return this.stopRequest;
            }
        }

        private void sleep(long millis){
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("stoppable runnable is running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.print(".");
            }
            System.out.println("stopped");
        }
    }


    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable=new StoppableRunnable();
        Thread t1=new Thread(stoppableRunnable);
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2=new Thread(()->{
            stoppableRunnable.requestStop();
        });
        t2.start();
        //stoppableRunnable.requestStop();
    }
}
