package com.jason.exercises.refrect;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/19.
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }
}
