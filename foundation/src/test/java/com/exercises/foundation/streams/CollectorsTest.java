package com.exercises.foundation.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/16.
 */
public class CollectorsTest {
    @Test
    public void test1() {
        List<Integer> result = IntStream.range(0, 1000).boxed().collect(Collectors.toCollection(ArrayList<Integer>::new));
        Assert.assertEquals(1000, result.size());
    }

    @Test
    public void test2() {
        List<Integer> result = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        Assert.assertEquals(1000, result.size());
    }

    @Test
    public void test3() {
        long time=System.currentTimeMillis();
        Map<Integer, Integer> map =
                IntStream.range(0, 1000).boxed()
                        .collect(
                                Collectors.toMap(
                                        Function.identity(),
                                        (x) -> x % 3
                                )
                        );
        System.out.println(System.currentTimeMillis()-time);
        Assert.assertEquals(1000, map.size());
        Assert.assertEquals(Integer.valueOf(0), map.get(111));
    }

}
