package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

import java.awt.*;

public class FrameExchanger {
    private long framesStoredCount =0;
    private long framesTakenCount = 0;
    private volatile boolean hasNewFrame=false;
    private Frame frame;

    public void storeFrame(Frame frame){
        while(hasNewFrame){
            //System.out.println("waiting");
        }

        this.frame=frame;
        this.framesStoredCount++;
        System.out.println("stored "+framesStoredCount);
        this.hasNewFrame=true;

    }

    public Frame takeFrame(){
        while(!hasNewFrame){
            //System.out.println("waiting");
        }
        Frame newFrame= this.frame;
        this.framesTakenCount++;
        System.out.println("taken "+framesStoredCount);
        this.hasNewFrame=false;
        return newFrame;
    }

    public long getFramesStoredCount() {
        return framesStoredCount;
    }

    public long getFramesTakenCount() {
        return framesTakenCount;
    }
}
