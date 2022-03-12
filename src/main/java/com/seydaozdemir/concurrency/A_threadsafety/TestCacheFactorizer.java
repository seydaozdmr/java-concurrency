package com.seydaozdemir.concurrency.A_threadsafety;

import java.math.BigInteger;

public class TestCacheFactorizer {
    public static void main(String[] args) {
        CacheFactorizer cacheFactorizer=new CacheFactorizer();

        for(int i=0;i<10;i++){
            Thread t1=new Thread(()->cacheFactorizer.getFactors(BigInteger.valueOf(8)));
            Thread t2=new Thread(()->cacheFactorizer.getFactors(BigInteger.valueOf(6)));
            t1.start();
            t2.start();
        }

    }
}
