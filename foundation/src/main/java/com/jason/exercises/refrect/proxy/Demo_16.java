package com.jason.exercises.refrect.proxy;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_16 {
    public static void main(String[] args) {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new RealSubject());
        String info = sub.say("Rollen", 20);
        System.out.println(info);
    }
}
