package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.threadlocal;

public class ThreadLocalInitialValue {

    ThreadLocal<Object> threadLocal=new ThreadLocal<>(){
        @Override
        protected Object initialValue() {
            return new Object();
        }
    };

    ThreadLocal<Object> threadLocal2=ThreadLocal.withInitial(()->new Object());

    Thread t1=new Thread(()->{
        System.out.println("ThreadLocal-1 - Thread-1"+threadLocal.get());
        System.out.println("ThreadLocal-2 - Thread-1"+threadLocal2.get());
    });
    Thread t2=new Thread(()->{
        System.out.println("ThreadLocal-1 - Thread-2"+threadLocal.get());
        System.out.println("ThreadLocal-2 - Thread-2"+threadLocal2.get());
    });

    public static void main(String[] args) {
        ThreadLocalInitialValue threadLocalInitialValue=new ThreadLocalInitialValue();
        threadLocalInitialValue.t1.start();
        threadLocalInitialValue.t2.start();
    }

}
