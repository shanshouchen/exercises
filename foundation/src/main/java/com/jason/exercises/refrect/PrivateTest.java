package com.jason.exercises.refrect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/19.
 */
public class PrivateTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Employee em = new Employee(1, "Alex", 22);
        //获取Class对象
        Class<?> emClass = em.getClass();

        //获取特定的声明了的方法
        Method judgeMethod = emClass.getDeclaredMethod("judge", new Class[]{Integer.TYPE});
        //setAccessible(boolean flag)使所有成员可以访问,访问之前设置
        judgeMethod.setAccessible(true);

        //获取所有声明的方法
        Method[] allMethods = emClass.getDeclaredMethods();
        //AccessibleObject.setAccessible(AccessibleObject[] array,boolean flag)批量给访问权限
        AccessibleObject.setAccessible(allMethods, true);

        //下面就可以通过反射访问了
        judgeMethod.invoke(em, new Object[]{3});

        //or...
        for (Method method : allMethods) {
            System.out.println(method.getName());
        }
    }
}
