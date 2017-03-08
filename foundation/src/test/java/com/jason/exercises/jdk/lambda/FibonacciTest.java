package com.jason.exercises.jdk.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.IntUnaryOperator;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class FibonacciTest {


    private IntUnaryOperator operator = new IntUnaryOperator() {
        @Override
        public int applyAsInt(int n) {
            return n < 2 ? n : applyAsInt(n - 1) + applyAsInt(n - 2);
        }
    };

    @Test
    public void test10() {
        Assert.assertEquals(55, operator.applyAsInt(10));
    }


}
