package com.seydaozdemir.concurrency.D_buildingblocks;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {
    private final Set<Integer> set=new HashSet<>();

    public synchronized void add(Integer i){
        set.add(i);
    }
    public synchronized void remove(Integer i){
        set.remove(i);
    }

    public void addTenThings(){
        Random random=new Random();
        for(int i=0;i<10;i++){
            add(random.nextInt());
        }
        System.out.println("DEBUG : added ten elements to :"+set);
    }

    public static void main(String[] args) {
        HiddenIterator hiddenIterator=new HiddenIterator();

        for(int i=0;i<10;i++) {
            Thread t1=new Thread(()->{
                hiddenIterator.addTenThings();
            });
            t1.start();
        }

    }
}
