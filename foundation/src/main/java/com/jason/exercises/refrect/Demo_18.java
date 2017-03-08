package com.jason.exercises.refrect;

import java.lang.reflect.Array;

/**
 * 反射操作多维数组
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_18 {
    public static void main(String[] args) {
        Object array = Array.newInstance(Integer.TYPE, 5, 10, 15);
        Object arrayObject = Array.get(array, 3);
        arrayObject = Array.get(arrayObject, 5);
        Array.set(arrayObject, 10, 37);
        Array.setInt(arrayObject,1,38);
        int[][][] arrayCast = (int[][][]) array;
        System.out.println(arrayCast[3][5][10]);
        System.out.println(arrayCast[3][5][1]);
        System.out.println(arrayCast[3][5][2]);
    }
}
