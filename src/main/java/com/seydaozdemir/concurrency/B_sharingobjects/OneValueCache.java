package com.seydaozdemir.concurrency.B_sharingobjects;

import java.math.BigInteger;
import java.util.Arrays;

public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger number, BigInteger[] factors) {
        this.lastNumber = number;
        this.lastFactors = Arrays.copyOf(factors,factors.length);
    }

    public BigInteger [] getFactors(BigInteger number){
        if(lastNumber==null || !lastNumber.equals(number)){
            return null;
        }else{
            return Arrays.copyOf(lastFactors,lastFactors.length);
        }
    }
}
