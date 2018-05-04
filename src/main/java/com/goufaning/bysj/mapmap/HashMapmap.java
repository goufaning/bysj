package com.goufaning.bysj.mapmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapmap<TKey, TSubKey, TValue> implements Mapmap<TKey, TSubKey, TValue> {

    private final HashMap<TKey, Map<TSubKey, TValue>> map;

    public HashMapmap() {
        map = new HashMap<TKey, Map<TSubKey, TValue>>();
    }

    @Override
    public void put(TKey key, TSubKey subKey, TValue value) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<TSubKey, TValue>());
        }
        map.get(key).put(subKey, value);
    }

    @Override
    public Map get(TKey key) {
        return map.get(key);
    }

    @Override
    public TValue get(TKey key, TSubKey subKey) {
        return map.get(key).get(subKey);
    }

    @Override
    public int size() {
        return map.size();
    }
}
