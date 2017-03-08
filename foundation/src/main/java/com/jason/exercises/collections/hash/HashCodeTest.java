package com.jason.exercises.collections.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/6.
 */
public class HashCodeTest {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list1.add(i);
        }
        long time2 = System.currentTimeMillis();
        List<Integer> list2 = new ArrayList<>(1000000);

        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list2.add(i);
        }
        long time4 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(time4 - time3);

        System.out.println(null instanceof Map);

        System.out.println(2>>1);
        System.out.println(16>>1);


    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
