package com.seydaozdemir.concurrency.D_buildingblocks.cache;

public interface Computable <A,V>{
    V compute(A arg) throws InterruptedException;
}
