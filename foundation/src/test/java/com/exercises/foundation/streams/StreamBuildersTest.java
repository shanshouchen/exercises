package com.exercises.foundation.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/16.
 */
public class StreamBuildersTest {

    @Test
    public void test1() {
        Stream<Integer> s = Stream.<Integer>builder().add(1).add(2).add(3).build();
        Assert.assertEquals(3, s.count());
    }

    @Test
    public void test2() {
        IntStream s = IntStream.builder().add(1).add(2).add(3).build();
        Assert.assertEquals(3, s.count());
    }

    @Test
    public void test4() {
        DoubleStream avg = DoubleStream.generate(Math::random);
        double d = avg.limit(1000000).average().getAsDouble();
        Assert.assertEquals(0.5D, d, 0.001);
    }

    @Test
    public void test5() {
        int sum = IntStream.range(0, 1000).sum();
        Assert.assertEquals(500500 - 1000, sum);
    }

    @Test
    public void test6() {
        int sum = IntStream.range(0, 1000).reduce((r1, r2) -> r2 + r1).getAsInt();
        Assert.assertEquals(500500 - 1000, sum);
    }

}
