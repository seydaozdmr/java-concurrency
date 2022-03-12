package com.seydaozdemir.concurrency.A_threadsafety;

public class Widget {
    public Object object=new Object();
    public void doSomething(String s){

            System.out.println("widget is runnin "+s );

        //System.out.println("widget is running");
    }
}
