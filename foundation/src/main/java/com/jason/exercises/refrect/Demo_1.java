package com.jason.exercises.refrect;


/**
 * Created by shanshouchen@weibangong.com on 2017/1/17.
 */
public class Demo_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> demo1=null;
        Class<?> demo2;
        Class<?> demo3;
        try{
            //一般尽量采用这种形式
            demo1=Class.forName("com.jason.exercises.refrect.Demo");
        }catch(Exception e){
            e.printStackTrace();
        }
        demo2=new Demo().getClass();
        demo3=Demo.class;

        System.out.println("类名称   "+demo1.getName());
        System.out.println("类名称   "+demo2.getName());
        System.out.println("类名称   "+demo3.getName());

    }
}
