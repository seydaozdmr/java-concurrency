package com.seydaozdemir.concurrency.D_buildingblocks;

import java.util.Vector;

public class VectorUtils<T> {

    public static <T> T getLast(Vector<T> list){
        synchronized (list){
            int lastIndex = list.size()-1;
            return list.get(lastIndex);
        }
    }

    public static <T> T deleteLast(Vector<T> list){
        synchronized (list){
            int lastIndex=list.size()-1;
            return list.remove(lastIndex);
        }
    }

    /**
     * By holding the Vector lock for the duration of iteration, as shown in Listing 5.4,
     * we prevent other threads from modifying the Vector while we are iterating it.
     */
    public static <T> void  printElements(Vector<T> list){
        synchronized (list){
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
}
