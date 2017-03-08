package com.jason.exercises.refrect;

/**
 * 获得所有接口
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_4 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.jason.exercises.refrect.Person_1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class<?> intes[] = demo.getInterfaces();
        for (int i = 0; i < intes.length; i++) {
            System.out.println("实现的接口   " + intes[i].getName());
        }
    }
}
