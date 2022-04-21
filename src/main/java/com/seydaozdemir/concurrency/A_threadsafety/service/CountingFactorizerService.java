package com.seydaozdemir.concurrency.A_threadsafety.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CountingFactorizerService {
    private final AtomicLong count=new AtomicLong(0);

    public long getCount(){
        return count.get();
    }

    public long inc(){
        return count.incrementAndGet();
    }
}
