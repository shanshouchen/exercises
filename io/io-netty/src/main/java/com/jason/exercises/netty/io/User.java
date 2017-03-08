package com.jason.exercises.netty.io;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/12.
 */
public class User {
    private String name = "test";
    private long id = 1;
    private int age = 2;
    private double height = 1.72;

    public User() {
        this.name = "test";
        this.age = 22;
    }

    @Override
    public String toString() {
        return name + "," + id + "," + age + "," + height;
    }
}
