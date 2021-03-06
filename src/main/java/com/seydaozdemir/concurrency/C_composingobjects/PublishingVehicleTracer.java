package com.seydaozdemir.concurrency.C_composingobjects;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PublishingVehicleTracer {
    private final Map<String,SafePoint> locations;
    private final Map<String,SafePoint> unmodifiableMap;

    public PublishingVehicleTracer(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap= Collections.unmodifiableMap(locations);
    }

    public Map<String,SafePoint> getLocations(){
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id){
        return locations.get(id);
    }

    public void setLocations(String id, int x,int y){
        if(!locations.containsKey(id))
            throw new IllegalArgumentException("invalid vehicle name "+id);
        locations.get(id).set(x,y);
    }


}
