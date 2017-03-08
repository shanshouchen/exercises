package com.jason.exercises.collections.map;

import java.util.TreeSet;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/17.
 */
class Person implements Comparable {

    private int age;
    private String name;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Person.class) {
            Person p = (Person) obj;
            if (this.name.equals(p.name) && this.age == p.age) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(Object obj) {
        Person p = (Person) obj;
        //如果只比较年龄，写法就非常简洁了。
        System.out.println(this.name + "compare to" + p.name);
        return this.age > p.age ? 1 : this.age < p.age ? -1 : 0;

    }

    public String toString() {
        return "[age:" + this.age + " name:" + this.name + "]";
    }
}

public class TreeSetDemo_03 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        System.out.println(ts.add(new Person("zhang", 10)));
        System.out.println(ts.add(new Person("wang", 12)));
        System.out.println(ts.add(new Person("li", 6)));
        System.out.println(ts.add(new Person()));
        System.out.println(ts.add(new Person("li", 6)));
        System.out.println("第二次添加无参数Person对象，成功？" + ts.add(new Person()));
        System.out.println(ts);
    }
}
