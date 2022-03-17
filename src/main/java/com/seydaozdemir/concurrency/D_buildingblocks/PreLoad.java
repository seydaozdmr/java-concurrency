package com.seydaozdemir.concurrency.D_buildingblocks;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PreLoad {
    private final FutureTask<List<Integer>> future =new FutureTask<>(
            (Callable<List<Integer>>) () -> loadList());

    private final Thread thread=new Thread(future);

    public void start(){
        thread.start();
    }

    public List<Integer> get() throws ExecutionException, InterruptedException {
        return future.get();
    }

    public List<Integer> loadList(){
        return Stream.iterate(0,i->i+1).limit(10000000).collect(Collectors.toList());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PreLoad preLoad=new PreLoad();

        preLoad.start();
        preLoad.get().stream().forEach(System.out::println);
    }

}
