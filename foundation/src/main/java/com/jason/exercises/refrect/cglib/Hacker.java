package com.jason.exercises.refrect.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/20.
 */
public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("*** I am a hacker, Let's see what the poor programer is doing Now...");
        proxy.invokeSuper(obj, args);
        System.out.println("*** Oh, What a poor programer...");
        return null;
    }
}
