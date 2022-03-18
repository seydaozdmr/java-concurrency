package com.seydaozdemir.concurrency.A_threadsafety.threadcreation;

public class Exchanger {
    private Object object=null;
    private volatile boolean hasNewObject =false;

    public void setObject(Object o){
        this.object=o;
        this.hasNewObject=true;
    }

    public Object getObject(){
        while(!hasNewObject){

        }
        Object object= this.object;
        this.hasNewObject=false;
        return object;
    }

    public static void main(String[] args) {
        Exchanger exchanger=new Exchanger();

        Thread t1=new Thread(()->{
            for(int i=0;i<10;i++){
                if(!exchanger.hasNewObject){
                    exchanger.setObject(new Object());
                }
                i--;
            }

        });
        Thread t2=new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(exchanger.getObject());
            }


        });
        t1.start();
        t2.start();
    }
}
