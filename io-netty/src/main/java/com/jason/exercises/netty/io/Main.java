package com.jason.exercises.netty.io;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by shanshouchen@weibangong.com on 24/12/2016.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
//        byte[] b = new byte[1024 * 1024 * 1024 - 1];
//        byte[] a = new byte[1];


//        ByteBuf buf = Unpooled.buffer(1024);
//        ByteBuf buf = Unpooled.directBuffer();
//        buf.writeBytes(b);
//        buf.writeBytes(a);
//        buf.writeBytes(a);
//        buf.writeBytes("Jason".getBytes());


        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

        User userFormNormal = new User();
        System.out.println(userFormNormal);

        Class userClass = userFormNormal.getClass();
        Field name = userClass.getDeclaredField("name");
        Field id = userClass.getDeclaredField("id");
        Field age = userClass.getDeclaredField("age");
        Field height = userClass.getDeclaredField("height");

        unsafe.putObject(userFormNormal, unsafe.objectFieldOffset(name), "modified-name");
        unsafe.putObject(userFormNormal, unsafe.objectFieldOffset(id), 1001);
        unsafe.putObject(userFormNormal, unsafe.objectFieldOffset(age), 101);
        unsafe.putObject(userFormNormal, unsafe.objectFieldOffset(height), 100.1);
        System.out.println(userFormNormal);



    }
}
