package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

import java.awt.*;

public class FrameExchanger {
    private long framesStoredCount =0;
    private long framesTakenCount = 0;
    private volatile boolean hasNewFrame=false;
    private Frame frame;

    public void storeFrame(Frame frame){

        this.frame=frame;
        this.framesStoredCount++;
        this.hasNewFrame=true;

    }

    public Frame takeFrame(){
        while(!hasNewFrame){

        }
        Frame newFrame= this.frame;
        this.framesTakenCount++;
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
