package com.exercises.foundation.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/16.
 */
public class ExternalInternalTest {
    @Test
    public void testExternal() {
        StringBuilder sb = new StringBuilder();

        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
        for (String s : strings) {
            sb.append(s);
        }
        Assert.assertEquals("FooBarBaz", sb.toString()
        );
    }

    @Test
    public void testInternal() {
        StringBuilder sb = new StringBuilder();

        List<String> strings = Arrays.asList("Foo", "Bar", "Baz");
        strings.forEach(sb::append);

        Assert.assertEquals("FooBarBaz", sb.toString()
        );
    }

}
