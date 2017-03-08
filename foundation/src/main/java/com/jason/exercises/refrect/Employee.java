package com.jason.exercises.refrect;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/19.
 */
public class Employee {
    private int id;
    private String name;
    private int age;

    public Employee() {

    }

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private void setId(int id) {
        this.id = id;
    }

    private int judge(int id) {
        return this.id - id;
    }

    private String sayHalo(String name) {
        return "Halo" + name;
    }
}
