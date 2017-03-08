package com.jason.exercises.jdk.lambda;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class UroborosTest {
    interface Uroboros {
        Uroboros bite();
    }

    @Test
    public void test() {
        Uroboros chain = () -> () -> () -> () -> () -> () -> () -> () -> () -> () -> null;



        int depth = 0;
        while (chain != null) {
            depth++;
            chain = chain.bite();
        }

        Assert.assertEquals(10, depth);
    }

    @Test
    public void testStructured() {
        Uroboros tail = () -> null;
        Uroboros sect1 = () -> tail;
        Uroboros sect2 = () -> sect1;
        Uroboros sect3 = () -> sect2;
        Uroboros sect4 = () -> sect3;
        Uroboros sect5 = () -> sect4;
        Uroboros chain = () -> sect5;

        int depth = 0;
        while (chain != null) {
            depth++;
            chain = chain.bite();
        }

        Assert.assertEquals(7, depth);
    }
}
