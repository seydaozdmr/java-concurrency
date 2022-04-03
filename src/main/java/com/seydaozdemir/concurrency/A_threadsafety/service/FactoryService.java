package com.seydaozdemir.concurrency.A_threadsafety.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactoryService {
    public List<Integer> getFactory(Integer number) {
        List<Integer> result = factory(number);
        return result;
    }

    private List<Integer> factory(Integer number) {
        List<Integer> result=new ArrayList<>();
        int num=1;
        for(int i=1;i<number;i++){
            result.add(num*=i);
        }
        return result;
    }
}
