package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.threadlocal;

public class ThreadLocalLazyInitialize {
    static ThreadLocal<String> threadLocal=new ThreadLocal();

    public static void main(String[] args) {
        String value=threadLocal.get();
        if(value==null){
            threadLocal.set("Lazy set value");
            value= threadLocal.get();
        }
        System.out.println(value);
    }
}
