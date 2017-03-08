package com.jason.exercises.refrect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 构造方法
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_6 {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("com.jason.exercises.refrect.Person_1");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Constructor<?> cons[]=demo.getConstructors();
        for (int i = 0; i < cons.length; i++) {
            System.out.println("构造方法：  "+cons[i]);
        }
    }
}
