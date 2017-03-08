package com.jason.exercises.refrect;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Person_1 implements China{
    public Person_1() {

    }

    public Person_1(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sayChina() {
        System.out.println("hello ,china");
    }

    public void sayHello(String name, int age) {
        System.out.println(name + "  " + age);
    }

    private String sex;
}
