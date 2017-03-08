package com.jason.exercises.jdk.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/15.
 */
public class MethodRefTest {
    @Test
    public void testMethodRefStatic() {
        Comparator<Integer> cmp = Integer::compare;

        Assert.assertEquals(1, cmp.compare(12, 11));
        Assert.assertEquals(0, cmp.compare(12, 12));
        Assert.assertEquals(-1, cmp.compare(12, 13));

    }

    @Test
    public void testMethodRefInstance0() {
        Consumer<String> b = System.out::println;
        Arrays.asList("Foo", "Bar", "Baz", "Baz", "Foo", "Bar").forEach(b);
    }

    private Predicate<String> makeCaseUnsensitiveMatcher(String pattern) {
        return pattern::equalsIgnoreCase;
    }

    @Test
    public void testMethodRefInstance1() {
        Assert.assertTrue(makeCaseUnsensitiveMatcher("true").test("TruE"));
        Assert.assertTrue(makeCaseUnsensitiveMatcher("false").test("FalsE"));
        Assert.assertFalse(makeCaseUnsensitiveMatcher("true").test("FalsE"));
    }

    @Test
    public void testMethodRefInstance2() {
        Predicate<String> isTrue = "true"::equalsIgnoreCase;
        Assert.assertTrue(isTrue.test("TruE"));
        Assert.assertFalse(isTrue.test("FalsE"));
    }

    @Test
    public void testMethodRefInstanceUnbound() {
        Comparator<Integer> cmp = Integer::compareTo;

        Assert.assertEquals(0, cmp.compare(0, 0));
        Assert.assertEquals(-1, cmp.compare(-100, 100));
        Assert.assertEquals(1, cmp.compare(100, -100));
    }

    @Test
    public void testParseInt() {
        Function<String, Integer> f = Integer::parseInt;
        Assert.assertEquals(Integer.valueOf(0), f.apply("0"));
        Assert.assertEquals(Integer.valueOf(1), f.apply("1"));
    }

    @Test
    public void testConstructor() {
        Function<String, Integer> f = Integer::new;
        Function<String, String> f1 = String::new;

        Assert.assertEquals(Integer.valueOf(0), f.apply("0"));
        Assert.assertEquals(Integer.valueOf(1), f.apply("1"));

        Assert.assertEquals("shan",f1.apply("shan"));
    }
    public static class Counter {

        public Counter() {
            this(0);
        }

        public Counter(int count) {
            this.count = count;
        }

        private int count = 0;

        public int inc() {
            return ++count;
        }

        public int get() {
            return count;
        }
    }

    @Test
    public void testConstructor0(){
        Supplier<Counter> f = Counter::new;
        Assert.assertEquals(0, f.get().get());
        Assert.assertEquals(1, f.get().inc());
    }

    @Test
    public void testConstructor1(){
        Function<Integer, Counter> f = Counter::new;
        Assert.assertEquals(1, f.apply(1).get());
        Assert.assertEquals(42, f.apply(42).get());
    }
}
