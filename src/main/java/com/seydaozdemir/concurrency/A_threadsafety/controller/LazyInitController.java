package com.seydaozdemir.concurrency.A_threadsafety.controller;

import com.seydaozdemir.concurrency.A_threadsafety.service.ExpensiveObject;
import com.seydaozdemir.concurrency.A_threadsafety.service.LazyInitRace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LazyInitController {
    private final LazyInitRace lazyInitRace;

    public LazyInitController(LazyInitRace lazyInitRace) {
        this.lazyInitRace = lazyInitRace;
    }

    @GetMapping("/lazyinit")
    public ExpensiveObject expensiveObject(){
        return lazyInitRace.getInstance();
    }

    @GetMapping("/lazyinit/count")
    public Long getCount(){
        return lazyInitRace.getCount();
    }
}
