package com.goufaning.bysj.mapmap;

import java.util.Map;

public interface Mapmap<TKey, TSubKey, TValue> {

    void put(TKey key, TSubKey subKey, TValue value);

    Map<TSubKey, TValue> get(TKey key);

    TValue get(TKey key, TSubKey subKey);

    int size();
}
