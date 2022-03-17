package com.seydaozdemir.concurrency.D_buildingblocks.cache;

import java.util.HashMap;
import java.util.Map;

public class Memorize<A,V> implements Computable<A,V> {
    private final Map<A,V> cache = new HashMap<>();
    private final Computable<A,V> computable;

    public Memorize(Computable<A, V> computable) {
        this.computable = computable;
    }

    public synchronized V compute ( A args) throws InterruptedException {
        V result= cache.get(args);
        if(result==null){
            result=computable.compute(args);
            cache.put(args,result);
        }
        return result;
    }
}
