package com.exercises.foundation.streams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/16.
 */
public class SeqParTest {
    private static final int COUNT = Integer.getInteger("count", 1_000_000);

    private List<Integer> list;
    int aa = 1_000_000;


    @Before
    public void setup() {
        list = new ArrayList<>(COUNT);
        for (int c = 1; c <= COUNT; c++) {
            list.add(c);
        }
        Collections.shuffle(list);
    }

    @Test
    public void testSeq() {
        long time = System.currentTimeMillis();
        Assert.assertEquals(Integer.valueOf(COUNT), list.stream().reduce(Math::max).get());
        System.out.println(System.currentTimeMillis() - time);
    }

    @Test
    public void testPar() {
        long time = System.currentTimeMillis();
        Assert.assertEquals(Integer.valueOf(COUNT), list.parallelStream().reduce(Math::max).get());
        System.out.println(System.currentTimeMillis() - time);
    }
}
