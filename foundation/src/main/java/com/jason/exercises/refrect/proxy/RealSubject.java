package com.jason.exercises.refrect.proxy;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class RealSubject implements Subject {
    public String say(String name, int age) {
        return name + " " + age;
    }
}
