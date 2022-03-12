package com.seydaozdemir.concurrency.A_threadsafety;

import java.math.BigInteger;
import java.util.Arrays;

public class CacheFactorizer {
    /**
     * LockFactorizer sınıfını senkronize bloklar daha dar bir alanda lock kullanacak
     * şekilde değiştirdik.
     */

    private BigInteger lastNumber;
    private BigInteger[] lastFactors;

    public void getFactors(BigInteger number){
        BigInteger[] factors=null;
        synchronized (this){
            if(number.equals(lastNumber)){
                factors=lastFactors.clone();
                System.out.println("cache worked!");
                Arrays.stream(factors).forEach(System.out::println);
            }
        }
        if(factors==null){
            factors =factor(number);
            System.out.println(Thread.currentThread().getName());
            synchronized (this){
                lastNumber=number;
                lastFactors = factors.clone();
                Arrays.stream(factors).forEach(System.out::println);
            }
        }
    }

    private BigInteger[] factor(BigInteger number) {
        BigInteger[] result=new BigInteger[number.intValue()];
        result[0]=BigInteger.ONE;
        BigInteger value=BigInteger.ONE;
        for(int i=1;i< number.intValue();i++){
            value=value.multiply(BigInteger.valueOf(i));
            result[i]=value;
        }
        return result;
    }
}
