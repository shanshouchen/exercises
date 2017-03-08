package com.jason.exercises.jdk.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/16.
 */
public class LazyEagerTest {
    private int invocations = 0;

    @Test
    public void testLazy() {
        Stream<String> stream = Arrays.asList("Foo", "Marco", "Bar", "Polo", "Baz")
                .stream()
                .filter((s) -> {
                    invocations++;
                    return s.length() == 3;
                });

        Iterator<String> i = stream.iterator();

        Assert.assertEquals("Foo", i.next());
        Assert.assertEquals(1, invocations);

        Assert.assertEquals("Bar", i.next());
        Assert.assertEquals(3, invocations);

        Assert.assertEquals("Baz", i.next());
        Assert.assertEquals(5, invocations);
    }

    @Test
    public void testEager() {
        List<String> list = Arrays.asList("Foo", "Marco", "Bar", "Polo", "Baz")
                .stream()
                .filter((s) -> {
                    invocations++;
                    return s.length() == 3;
                })
                .collect(Collectors.toList());

        Assert.assertEquals(3, list.size());
        Assert.assertEquals(5, invocations);
    }
}
