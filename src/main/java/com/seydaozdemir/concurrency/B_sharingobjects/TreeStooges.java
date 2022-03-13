package com.seydaozdemir.concurrency.B_sharingobjects;

import java.util.HashSet;
import java.util.Set;

//immutable constructed class example
public final class TreeStooges {
    private final Set<String> stooges= new HashSet<>();

    public TreeStooges(){
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curry");
    }

    public boolean isStooge(String name){
        return stooges.contains(name);
    }
}
