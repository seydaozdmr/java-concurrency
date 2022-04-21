package com.seydaozdemir.concurrency.A_threadsafety.controller;

import com.seydaozdemir.concurrency.A_threadsafety.service.CountingFactorizerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountingFactorizerController {
    private final CountingFactorizerService service;

    public CountingFactorizerController(CountingFactorizerService service) {
        this.service = service;
    }

    @GetMapping("/count")
    public long incAndGet(){
        return service.inc();
    }
}
