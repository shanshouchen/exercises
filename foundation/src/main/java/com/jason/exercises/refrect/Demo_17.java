package com.jason.exercises.refrect;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_17 {
    public static void main(String[] args) {
        Fruit fruit = Factory.getInstance("com.jason.exercises.refrect.Apple");
        if (fruit != null) {
            fruit.eat();
        }
        Fruit fruit1 = Factory.getInstance("com.jason.exercises.refrect.Orange");
        if (fruit1 != null) {
            fruit1.eat();
        }
    }
}
