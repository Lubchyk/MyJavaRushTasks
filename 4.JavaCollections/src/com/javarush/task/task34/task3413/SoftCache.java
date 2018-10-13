package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if (softReference == null) return null;
        else return softReference.get();
    }

    public AnyObject put(Long key, AnyObject value) {
        AnyObject anyObject = get(key);
        if (anyObject == null) {
            cacheMap.put(key, new SoftReference<>(value));
            return null;
        } else {
            remove(key);
            cacheMap.put(key, new SoftReference<>(value));
            return anyObject;
        }
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> anyObjectSoftReference = cacheMap.get(key);
        if (anyObjectSoftReference!= null) {
            AnyObject anyObject = anyObjectSoftReference.get();
            cacheMap.remove(anyObjectSoftReference);
            anyObjectSoftReference.clear();
            return anyObject;
        } else return null;
    }
}