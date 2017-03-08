package com.exercises.foundation.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class NoiseSampleTest {
    public static class Counter {

        private int count = 0;

        public Counter() {
            this(0);
        }

        public Counter(int count) {
            this.count = count;
        }

        public int inc() {
            return ++count;
        }

        public int get() {
            return count;
        }
    }

    Map<String, Map<String, Counter>> map;

    static class ComputeMap<K, V> extends HashMap<K, V> {

        private final Supplier<V> factory;

        public ComputeMap(Supplier<V> factory) {
            this.factory = factory;
        }

        @Override
        public V get(Object key) {
            K k = (K) key;
            V v = super.get(key);
            if (v == null) {
                v = factory.get();
                super.put(k, v);
            }
            return v;
        }
    }

    @Test
    public void test() {
        Map<String, Map<String, Counter>> map = new ComputeMap<>(new Supplier<Map<String, Counter>>() {
            @Override
            public Map<String, Counter> get() {
                return new ComputeMap<>(new Supplier<Counter>() {
                    @Override
                    public Counter get() {
                        return new Counter();
                    }
                });
            }
        });


        Assert.assertEquals(1, map.get("foo").get("bar").inc());
        Assert.assertEquals(2, map.get("foo").get("bar").inc());
    }

    @Test
    public void testL0() {
        Map<String, Map<String, Counter>> map = new ComputeMap<>(() -> new ComputeMap<>(() -> new Counter()));

        Assert.assertEquals(1, map.get("foo").get("bar").inc());
        Assert.assertEquals(2, map.get("foo").get("bar").inc());
    }

    @Test
    public void testL1() {
        Supplier<Map<String, Counter>> mapFactory = () -> new ComputeMap<>(() -> new Counter());
        Map<String, Map<String, Counter>> map = new ComputeMap<>(mapFactory);

        Assert.assertEquals(1, map.get("foo").get("bar").inc());
        Assert.assertEquals(2, map.get("foo").get("bar").inc());
    }
    @Test
    public void testL2() {
        Map<String, Map<String, Counter>> map = new ComputeMap<>(() -> new ComputeMap<>(() -> new Counter()));

        Assert.assertEquals(1, map.get("foo").get("bar").inc());
        Assert.assertEquals(2, map.get("foo").get("bar").inc());
    }

    @Test
    public void testR() {
        Map<String, Map<String, Counter>> map = new ComputeMap<>(() -> new ComputeMap<>(Counter::new));

        Assert.assertEquals(1, map.get("foo").get("bar").inc());
        Assert.assertEquals(2, map.get("foo").get("bar").inc());
    }
}
