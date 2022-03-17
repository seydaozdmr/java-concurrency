package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

import java.awt.*;

public class MyRunnableSharedInteger implements Runnable{
    private Integer val;

    public MyRunnableSharedInteger(Integer val ){
        this.val = val;
    }


    @Override
    public void run() {
        for(int i=0;i<1_000_000;i++){
            val+=i;
        }
        System.out.println(Thread.currentThread().getName()+" : "+val);
    }
}
