package com.jason.exercises.refrect;

/**
 * 获得类加载器
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_15 {
    public static void main(String[] args) {
        Person_1 person = new Person_1();
        System.out.println("类加载器  " + person.getClass().getClassLoader().getClass().getName());
    }
}
