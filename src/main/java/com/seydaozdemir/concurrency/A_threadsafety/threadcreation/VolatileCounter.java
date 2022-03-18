package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

import java.util.Arrays;

public class VolatileCounter {
    private volatile int count=0;

    public boolean inc(){
        if(this.count==10){
            return false;
        }
        count++;
        return true;
    }

    public static void main(String[] args) {
        VolatileCounter volatileCounter=new VolatileCounter();

        Thread t1=new Thread(()->{
            int myCounter=0;
            boolean [] counter=new boolean[100];
            for(int i=0;i<100;i++){
                counter[i]= volatileCounter.inc();
            }

            for(int i=0;i<counter.length;i++) {
                if(counter[i]==true)
                    myCounter++;
            }
            System.out.println("thread-1 : "+myCounter);
        });
        Thread t2=new Thread(()->{
            int myCounter=0;
            boolean [] counter=new boolean[100];
            for(int i=0;i<100;i++){
                counter[i]= volatileCounter.inc();
            }

            for(int i=0;i<counter.length;i++) {
                if(counter[i]==true)
                    myCounter++;
            }
            System.out.println("thread-2 : "+myCounter);
        });

        t1.start();
        t2.start();

    }
}
