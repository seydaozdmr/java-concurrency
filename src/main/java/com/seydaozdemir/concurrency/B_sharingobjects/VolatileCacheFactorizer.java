package com.seydaozdemir.concurrency.B_sharingobjects;

import java.math.BigInteger;
import java.util.Arrays;

public class VolatileCacheFactorizer {
    private volatile OneValueCache cache= new OneValueCache(null,null);

    public void getFactors(BigInteger number){
        BigInteger[] factors= cache.getFactors(number);
        if(factors==null){
            factors=factor(number);
            cache=new OneValueCache(number,factors);
        }
        Arrays.stream(cache.getFactors(number)).forEach(System.out::println);
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
