package com.jason.exercises.collections.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/13.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("a_key", "a_value");
        map.put("b_key", "b_value");
        map.put("c_key", "c_value");
        Set<String> keys = map.keySet();
        Iterator<String> iterator=keys.iterator();

        keys.forEach(s -> System.out.println(map.get(s)));
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
