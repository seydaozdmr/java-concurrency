package com.seydaozdemir.concurrency.A_threadsafety;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class LockFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors= new AtomicReference<>();

    public synchronized void getFactors(BigInteger number){
        if(number.equals(lastNumber.get())){
            System.out.println("cache worked!");
            Arrays.stream(lastFactors.get()).forEach(System.out::println);
        }else{
            BigInteger [] factors=factor(number);
            lastNumber.set(number);
            lastFactors.set(factors);
            Arrays.stream(lastFactors.get()).forEach(System.out::println);
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
