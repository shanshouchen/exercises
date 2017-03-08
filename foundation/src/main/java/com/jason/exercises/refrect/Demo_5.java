package com.jason.exercises.refrect;

/**
 * 获得父类
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_5 {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("com.jason.exercises.refrect.Person_1");
        }catch (Exception e) {
            e.printStackTrace();
        }
        //取得父类
        Class<?> temp=demo.getSuperclass();
        System.out.println("继承的父类为：   "+temp.getName());
    }
}
