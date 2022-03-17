package com.seydaozdemir.concurrency.D_buildingblocks.cache;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger>{
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //after deep thought
        return new BigInteger(arg);
    }
}
