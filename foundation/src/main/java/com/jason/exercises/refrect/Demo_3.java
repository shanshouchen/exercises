package com.jason.exercises.refrect;

import java.lang.reflect.Constructor;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/18.
 */
public class Demo_3 {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("com.jason.exercises.refrect.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Person per1=null;
        Person per2=null;
        Person per3=null;
        Person per4=null;
        //取得全部的构造函数
        Constructor<?> cons[]=demo.getConstructors();
        try{
            per1=(Person)cons[0].newInstance();
            per2=(Person)cons[1].newInstance("Rollen");
            per3=(Person)cons[2].newInstance(20);
            per4=(Person)cons[3].newInstance("Rollen",20);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(per1);
        System.out.println(per2);
        System.out.println(per3);
        System.out.println(per4);
    }
}
