package com.seydaozdemir.concurrency.A_threadsafety.controller;

import com.seydaozdemir.concurrency.A_threadsafety.service.UnSafeCachingFactorizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class UnSafeCachingController {
    private final UnSafeCachingFactorizer unSafeCachingFactorizer;

    public UnSafeCachingController(UnSafeCachingFactorizer unSafeCachingFactorizer) {
        this.unSafeCachingFactorizer = unSafeCachingFactorizer;
    }

    @GetMapping("/factory")
    public BigInteger [] getFactory(@RequestParam int number){
        return unSafeCachingFactorizer.service(number);
    }
}
