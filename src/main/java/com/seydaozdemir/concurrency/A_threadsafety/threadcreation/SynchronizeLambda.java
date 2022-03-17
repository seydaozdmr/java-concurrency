package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

import java.util.function.Consumer;

public class SynchronizeLambda {
    private static Object object;

    //burada kullanılan monitor object ile main içerisindeki consumeObject
    //metodunda kullanılan SynchronizeLambda.class aynıdır. (static olduğu için)
    public synchronized void setObject(Object o){
        object=o;
    }

    public static void consumeObject(Consumer consumer){
        consumer.accept(object);
    }

    public static void main(String[] args) {
        consumeObject(o->{
            synchronized (SynchronizeLambda.class){
                System.out.println(o);
            }
        });
    }
}
