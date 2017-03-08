package com.jason.exercises.refrect;

import java.lang.reflect.Method;

/**
 * 反射调用其他类中的方法
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_10 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.jason.exercises.refrect.Person_1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method method = demo.getMethod("sayChina");
            method.invoke(demo.newInstance());
            method = demo.getMethod("sayHello", String.class, int.class);
            method.invoke(demo.newInstance(), "Rollen", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
