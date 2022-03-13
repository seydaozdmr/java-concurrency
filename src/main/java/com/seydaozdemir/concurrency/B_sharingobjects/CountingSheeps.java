package com.seydaozdemir.concurrency.B_sharingobjects;

public class CountingSheeps {
    /**
     * You can use volatile variables only when all the following criteria are met:
     *
     * Writes to the variable do not depend on its current value, or you can ensure
     * that only a single thread ever updates the value;
     * The variable does not participate in invariants with other state variables; and
     * Locking is not required for any other reason while the variable is being accessed.
     */
    private boolean isSleep;
    private int i=0;
    private void countSomeSheep(){
        System.out.println(i++);
    }

    public static void main(String[] args) throws InterruptedException {
        CountingSheeps countingSheeps=new CountingSheeps();

        Thread t1=new Thread(()->{
            while(!countingSheeps.isSleep){
                countingSheeps.countSomeSheep();
            }
        });
        t1.start();
        Thread.sleep(5000);
        countingSheeps.isSleep=true;
    }
}
