package com.jason.exercises.refrect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 全部属性
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_9 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.jason.exercises.refrect.Person_1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===============本类属性========================");
        Field[] field = demo.getDeclaredFields();
        println(field);
        System.out.println("===============实现的接口或者父类的属性========================");
        Field[] filed1 = demo.getFields();
        println(filed1);
    }

    private static void println(Field[] fields) {
        for (int i = 0; i < fields.length; i++) {
            int mo = fields[i].getModifiers();
            String priv = Modifier.toString(mo);
            Class<?> type = fields[i].getType();
            System.out.println(priv + " " + type.getName() + " "
                    + fields[i].getName() + ";");
        }
    }
}
