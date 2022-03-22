package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.racecondition;

public class RaceCondition {
    Runnable r1=new Runnable() {
        int x=0;
        @Override
        public void run() {
            x++;
        }
    };

    public static void main(String[] args) {
        Data d=new Data();

        Thread t1=new Thread(()->{
            Data d2=new Data();
            int x=0;
            for(int i=0;i<1000;i++) {
                d.increment();
                x++;
            }
            System.out.println("result - 1:"+x);
            System.out.println(d2.y);
        });

//        Thread t2=new Thread(()->{
//            int x=0;
//            for(int i=0;i<1000;i++){
//                d.increment();
//                x++;
//            }
//            System.out.println("result - 2:"+x);
//        });

        t1.start();
        //t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(d.count);
    }
}
class Data{
    int count=0;
    int y=0;
    void increment(){
        this.count++;
        y++;
    }
}
