package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

import java.awt.*;

public class ThreadExample16FrameExchanger {
    public static void main(String[] args) {
        FrameExchanger frameExchanger=new FrameExchanger();
        Runnable store=()->{
            frameExchanger.storeFrame(new Frame());
            System.out.println("stored : "+ frameExchanger.getFramesStoredCount());
        };
        Runnable take=()->{
            Frame taken = frameExchanger.takeFrame();
            System.out.println("taken : "+ frameExchanger.getFramesTakenCount()+ " "+taken);
        };
        for(int i=0;i<20;i++){
            Thread t1 = new Thread(store);
            t1.start();
            Thread t2=new Thread(take);
            t2.start();
        }
    }
}
