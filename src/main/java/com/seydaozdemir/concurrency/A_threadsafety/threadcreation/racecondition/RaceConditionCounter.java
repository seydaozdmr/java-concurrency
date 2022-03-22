package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;


public class RaceConditionCounter {
    public static void main(String[] args) {
        Counter counter=new Counter();

        Thread t1=new Thread(myRunnable(counter,"Thread -1 "));
        Thread t2=new Thread(myRunnable(counter,"Thread -2 "));
        t1.start();
        t2.start();
    }

    private static Runnable myRunnable(Counter counter,String message){
      return ()->{
          for(int i=0;i<1_000_000;i++){
              counter.incAndGet();
          }
          System.out.println(message+" : "+counter.get());
      };
    }
}
