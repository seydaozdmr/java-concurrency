package com.seydaozdemir.concurrency.A_threadsafety.service;

public class ExpensiveObject {
    private String message;

    public ExpensiveObject() {
        this.message="response message";
        System.out.println("Expensive object has created.");
    }

    public String getMessage() {
        return message;
    }
}
