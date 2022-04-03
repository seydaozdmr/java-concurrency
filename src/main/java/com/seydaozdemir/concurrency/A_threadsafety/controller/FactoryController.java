package com.seydaozdemir.concurrency.A_threadsafety.controller;

import com.seydaozdemir.concurrency.A_threadsafety.service.FactoryService;
import com.seydaozdemir.concurrency.A_threadsafety.service.UnsafeCountingFactoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FactoryController {
    private final FactoryService factoryService;
    private final UnsafeCountingFactoryService unsafeCountingFactoryService;

    public FactoryController(FactoryService factoryService, UnsafeCountingFactoryService unsafeCountingFactoryService) {
        this.factoryService = factoryService;
        this.unsafeCountingFactoryService = unsafeCountingFactoryService;
    }

    @GetMapping("/factory/{number}")
    public List<Integer> getFactory(@PathVariable Integer number){
        return factoryService.getFactory(number);
    }

    @GetMapping("/unsafefactory/{number}")
    public List<Integer> getUnSafeFactory(@PathVariable Integer number){
        return unsafeCountingFactoryService.getFactory(number);
    }
    @GetMapping("/getCount")
    public Long getCount(){
        return unsafeCountingFactoryService.getCount();
    }
}
