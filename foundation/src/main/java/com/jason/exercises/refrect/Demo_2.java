package com.jason.exercises.refrect;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_2 {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.jason.exercises.refrect.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person per = null;
        try {
            per = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        per.setName("Rollen");
        per.setAge(20);
        System.out.println(per);
    }
}
