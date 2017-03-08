package com.jason.exercises.refrect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 从字节码创建Class对象
 * Created by shanshouchen@weibangong.com on 2017/1/19.
 */
public class TestClassLoader {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        //读取本地的class文件内的字节码，转换成字节码数组
        InputStream input = new FileInputStream("/Users/jason/Workspace/exercises/connections/build/classes/main/com/jason/exercises/refrect/Programmer.class");
        byte[] result = new byte[1024];

        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(result, 0, count);
        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        Object o = clazz.newInstance();
        try {
            //调用Programmer的code方法
            clazz.getMethod("code", null).invoke(o, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
