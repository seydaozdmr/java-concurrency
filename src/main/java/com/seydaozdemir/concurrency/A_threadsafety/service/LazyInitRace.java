package com.seydaozdemir.concurrency.A_threadsafety.service;

import org.springframework.stereotype.Service;

@Service
public class LazyInitRace {
    private ExpensiveObject expensiveObject;
    private long count;

    public ExpensiveObject getInstance(){
        //943 adet nesne yaratılmış
        if(this.expensiveObject==null){
            count++;
            return new ExpensiveObject();
        }
        return this.expensiveObject;
    }

    public Long getCount(){
        return this.count;
    }
}
