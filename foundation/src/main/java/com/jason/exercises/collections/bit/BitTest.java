package com.jason.exercises.collections.bit;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/13.
 */
public class BitTest {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1111111111111111111111111111111", 2));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.parseInt("10000000000000000000000000000000", 2));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }
}
