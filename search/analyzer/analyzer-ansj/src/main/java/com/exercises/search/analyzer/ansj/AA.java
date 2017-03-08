package com.exercises.search.analyzer.ansj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shanshouchen@weibangong.com on 26/12/2016.
 */
public class AA {
    public static void main(String[] args) {

        int day_offset = 1;
        int days = 7;
        int index = days;
        List<String> loadDataInfoMeta = new ArrayList<>();
        loadDataInfoMeta.add("1");
        loadDataInfoMeta.add("2");
        loadDataInfoMeta.add("3");
        loadDataInfoMeta.add("4");
        loadDataInfoMeta.add("expect");
        for (int i = day_offset; i <= day_offset + days - 1; i++, index--) {
            System.out.println("倒数第几:" + i);
            for (String meta : loadDataInfoMeta) {
                if (index % 7 != 0 && meta.indexOf("expect") != -1) {
                    System.out.println("continue");
                    continue;
                } else {
                    int start = days + day_offset - index - 1;
                    int end = 7 - day_offset - (days - index);
                    System.out.printf("day:%d\toffset:%d\tstart:%d\tend:%d\tindex:%d\n", i, day_offset, start, end, index);
                }
            }
        }
    }
}
