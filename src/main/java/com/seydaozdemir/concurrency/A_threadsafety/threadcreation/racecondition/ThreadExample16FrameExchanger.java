package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

import com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition.FrameExchanger;

import java.awt.*;

public class ThreadExample16FrameExchanger {
    public static void main(String[] args) {
        FrameExchanger frameExchanger=new FrameExchanger();
        Runnable store=()->{
            for(int i=0;i<1000;i++){
                frameExchanger.storeFrame(new Frame());
                //System.out.println("stored : "+ frameExchanger.getFramesStoredCount());
            }

        };
        Runnable take=()->{
            for(int i=0;i<1000;i++ ){
                Frame taken = frameExchanger.takeFrame();
                //System.out.println("taken : "+ frameExchanger.getFramesTakenCount()+ " "+taken);
            }

        };
            Thread t1 = new Thread(store);
            t1.start();
            Thread t2=new Thread(take);
            t2.start();

    }
}
