package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V v = cache.get(key);
        if (Objects.nonNull(v)) return v;
        V constructor = clazz.getConstructor(key.getClass()).newInstance(key);
        return cache.put(key, constructor);
    }

    public boolean put(V obj) {
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey" ,null);
            getKey.setAccessible(true);
            K invoke = (K) getKey.invoke(obj);
            cache.put(invoke, obj);
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
