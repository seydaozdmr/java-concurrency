package com.seydaozdemir.concurrency.A_threadsafety;

public class ReentrantLockTest {
    /**
     * Reentrancy facilitates encapsulation of locking behavior,
     * and thus simplifies the development of object-oriented concurrent code.
     * Without reentrant locks, the very natural-looking code in Listing 2.7,
     * in which a subclass overrides a synchronized method and then calls the superclass method,
     * would deadlock. Because the doSomething methods in Widget and LoggingWidget are both synchronized,
     * each tries to acquire the lock on the Widget before proceeding. But if intrinsic locks were
     * not reentrant, the call to super.doSomething would never be able to acquire the lock because
     * it would be considered already held, and the thread would permanently stall waiting for a lock
     * it can never acquire. Reentrancy saves us from deadlock in situations like this.
     */
    public static void main(String[] args) {
        LoggingWidget loggingWidget=new LoggingWidget();
        for(int i=0;i<1000;i++){
            new Thread(()->loggingWidget.doSomething(Thread.currentThread().getName())).start();
        }
        //t1.start();
       // t2.start();
        //loggingWidget.doSomething();
    }
}
