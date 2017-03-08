package com.jason.exercises.refrect;

import java.lang.reflect.Array;

/**
 * 反射改变数组的信息
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_13 {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }
}
