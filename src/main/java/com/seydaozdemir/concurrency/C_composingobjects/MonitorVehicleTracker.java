package com.seydaozdemir.concurrency.C_composingobjects;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MonitorVehicleTracker {
    private final Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String,MutablePoint> getLocations(){
        /**
         * Bu map'i dışarıya deepCopy olarak veriyor.
         */
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocations(String id){
        MutablePoint p=locations.get(id);
        return Objects.requireNonNull(p,"aranan nesne bulunamadı");
    }

    public synchronized void setLocation(String id,int x,int y){
        /**
         * Similarly, the updater threads would modify vehicle locations with
         * data received from GPS devices or entered manually by a dispatcher through a GUI interface:
         */
        MutablePoint p=locations.get(id);
        Objects.requireNonNull(p,"aranan nesne bulunamadı");
        p.x=x;
        p.y=y;
    }

    private static Map<String,MutablePoint> deepCopy (Map<String,MutablePoint> m){
        Map<String,MutablePoint> result = new HashMap<>();
        for(String id : m.keySet()){
            result.put(id,new MutablePoint(m.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}
