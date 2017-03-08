package com.jason.exercises.collections.map;

import java.util.EnumSet;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/17.
 */
public class EnumSetDemo_01 {
    public static void main(String[] args) {
        //创建一个包含所有SeasonEnum枚举的EnumSet
        EnumSet es1 = EnumSet.allOf(SeasonEnum.class);
        System.out.println(es1);
        //创建一个空的EnumSet
        EnumSet es2 = EnumSet.noneOf(SeasonEnum.class);
        System.out.println(es2);
        es2.add(SeasonEnum.WINTER);
        es2.add(SeasonEnum.SPRING);
        System.out.println(es2);
        //创建一个由指定的枚举类的其中的几个元素组成的EnumSet
        EnumSet es3 = EnumSet.of(SeasonEnum.SUMMER, SeasonEnum.WINTER);
        System.out.println(es3);
        //EnumSet中包含了从SUMMER到WINTER的所有元素
        EnumSet es4 = EnumSet.range(SeasonEnum.SUMMER, SeasonEnum.WINTER);
        System.out.println(es4);
        //创建一个es4一样的EnumSet
        EnumSet es5 = EnumSet.complementOf(es4);
    }
}
