package com.jason.exercises.refrect;

import java.lang.reflect.Field;

/**
 * 通过反射操作属性
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_12 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> demo;
        Object obj;

        demo = Class.forName("com.jason.exercises.refrect.Person_1");
        obj = demo.newInstance();

        Field field = demo.getDeclaredField("sex");
        field.setAccessible(true);
        field.set(obj, "男");
        System.out.println(field.get(obj));
    }
}
