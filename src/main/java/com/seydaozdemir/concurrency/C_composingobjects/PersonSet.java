package com.seydaozdemir.concurrency.C_composingobjects;

import java.util.HashSet;
import java.util.Set;

public class PersonSet {
    /**
     * The only code paths that can access mySet are addPerson and containsPerson,
     * and each of these acquires the lock on the PersonSet.
     * All its state is guarded by its intrinsic lock, making PersonSet thread-safe.
     */

    private final Set<Person> mySet=new HashSet<>();

    public synchronized void addPerson(Person p){
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p){
        return mySet.contains(p);
    }
}
