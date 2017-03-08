package com.jason.exercises.refrect.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/20.
 */
public class Test {
    public static void main(String[] args) {
        Object programmer = new Programmer();
        Hacker hacker = new Hacker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(programmer.getClass());
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();
    }
}
