package com.seydaozdemir.concurrency.A_threadsafety.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UnSafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber=new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors=new AtomicReference<>();

    public BigInteger[] service(int request){
        BigInteger i=BigInteger.valueOf(request);
        if(i.equals(lastNumber.get())){
            return lastFactors.get();
        }else{
            BigInteger[] factors = factory(i);
            lastNumber.set(i);
            lastFactors.set(factors);
        }
        return this.lastFactors.get();
    }


    private BigInteger[] factory(BigInteger number) {
        BigInteger[] result=new BigInteger[number.intValue()-1];

        int num=1;
        for(int i=1;i<number.intValue();i++){
            result[i-1]=BigInteger.valueOf(num*=i);
        }
        return result;
    }
}
