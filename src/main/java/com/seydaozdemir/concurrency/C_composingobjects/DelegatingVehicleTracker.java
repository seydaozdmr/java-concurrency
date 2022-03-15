package com.seydaozdemir.concurrency.C_composingobjects;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DelegatingVehicleTracker {
    private final ConcurrentMap<String,ImmutablePoint> locations;
    private final Map<String,ImmutablePoint> unmodifiableMap;

    public DelegatingVehicleTracker(Map<String, ImmutablePoint> points) {
        this.locations = new ConcurrentHashMap<>(points);
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String,ImmutablePoint> getLocations(){
        return unmodifiableMap;
    }

    public ImmutablePoint getPoint(String id){
        return locations.get(id);
    }

    public void setLocations (String id,int x,int y){
        if(locations.replace(id,new ImmutablePoint(x,y))==null){
            throw new IllegalArgumentException("invalid vehicle name :"+id);
        }
    }
}
