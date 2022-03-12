package com.seydaozdemir.concurrency.A_threadsafety;

public class LoggingWidget extends Widget{
    public Object myObject= new Object();
    public synchronized void doSomething(String s){
            System.out.println("logging widget calling doSomething "+ s);
            super.doSomething(s);
    }
}
