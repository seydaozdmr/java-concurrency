package com.seydaozdemir.concurrency.A_threadsafety;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        LockFactorizer lockFactorizer=new LockFactorizer();
        //lockFactorizer.getFactors(BigInteger.valueOf(6));
        //lockFactorizer.getFactors(BigInteger.valueOf(6));

        Thread t1 = null;
        Thread t2= null;
        for(int i=0;i<10;i++){
            t1 = new Thread(() -> lockFactorizer.getFactors(BigInteger.valueOf(10)));
            t2 = new Thread(()->lockFactorizer.getFactors(BigInteger.valueOf(5)));
            t1.start();
            t2.start();
        }

        t1.join();
        t2.join();
    }
}
