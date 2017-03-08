package com.jason.exercises.loop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/13.
 */
public class ForTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(100000000);
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.add(i + "");
        }


        String str = null;
        for (String val : list) {
            str = val;
        }
        long time2 = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
        }
        long time3 = System.currentTimeMillis();
        System.out.println(str);
        System.out.printf("%d ms\t %d ms", (time2 - time1), (time3 - time2));
    }
}
