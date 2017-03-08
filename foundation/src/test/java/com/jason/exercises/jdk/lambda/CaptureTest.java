package com.jason.exercises.jdk.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class CaptureTest {

    @Test
    public void testLegacy() {
        final int minus_one = -1;
        final int zero = 0;
        final int one = 1;
        Comparator<Integer> cmp = (o1, o2) -> (o1 < o2) ? minus_one : ((o1 > o2) ? one : zero);

        Assert.assertEquals(minus_one, cmp.compare(10, 11));
        Assert.assertEquals(zero, cmp.compare(10, 10));
        Assert.assertEquals(one, cmp.compare(10, 9));

    }


    private Predicate<String> makeCaseUnsensitiveMatcher(String pattern) {
        return s -> pattern.equalsIgnoreCase(s);
    }

    @Test
    public void lambda1() {
        Assert.assertTrue(makeCaseUnsensitiveMatcher("true").test("truE"));
        Assert.assertTrue(makeCaseUnsensitiveMatcher("false").test("False"));
        Assert.assertFalse(makeCaseUnsensitiveMatcher("true").test("FalsE"));
    }


}
