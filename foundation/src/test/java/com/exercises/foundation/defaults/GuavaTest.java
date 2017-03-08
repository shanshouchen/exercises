package com.exercises.foundation.defaults;

import com.google.common.collect.TreeMultiset;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class GuavaTest {
    @Test
    public void testTreeMultiset() {
        TreeMultiset<String> strings = TreeMultiset.create();
        strings.add("Foo");
        strings.add("Bar");
        strings.add("Baz");

        String result = strings.stream().reduce((s1, s2) -> s1 + ", " + s2).get();
        Assert.assertEquals("Bar, Baz, Foo", result);
    }
}
