package com.jason.exercises.annotation;

import sun.misc.Unsafe;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/22.
 */
@HelloAnnotation(say = "Do it!")
public class TestMain {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloAnnotation annotation=TestMain.class.getAnnotation(HelloAnnotation.class);
        System.out.println(annotation.say());
    }
}
