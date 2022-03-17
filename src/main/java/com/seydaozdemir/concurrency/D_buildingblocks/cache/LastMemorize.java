package com.seydaozdemir.concurrency.D_buildingblocks.cache;

import java.util.concurrent.*;

public class LastMemorize <A,V> implements Computable<A,V>{
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A,V> computable;

    public LastMemorize(Computable<A, V> computable) {
        this.computable = computable;
    }

    public V compute (final A args) throws InterruptedException{
        while (true){
            Future<V> future=cache.get(args);
            if(future==null){
                Callable<V> eval=new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return computable.compute(args);
                    }
                };
                FutureTask<V> futureTask=new FutureTask<>(eval);
                future=cache.putIfAbsent(args,futureTask);
                if(future==null) {
                    future= futureTask;
                    futureTask.run();
                }
            }
            try{
                return future.get();
            }catch (CancellationException e){
                cache.remove(args,future);
            }catch (ExecutionException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
