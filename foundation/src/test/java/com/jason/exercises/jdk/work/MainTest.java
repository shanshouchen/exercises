package com.jason.exercises.jdk.work;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class MainTest {


    public static void main(String[] args) {
        ThreadPoolSolution solution1 = new ThreadPoolSolution();
        MultimapSolution solution2 = new MultimapSolution();
        InvertedIndexSolution solution3 = new InvertedIndexSolution();

        Set<Long> rangeIds = new HashSet<>();
        rangeIds.add(1155347L);
        rangeIds.add(17606L);
        rangeIds.add(1127451L);
        rangeIds.add(1172988L);
        rangeIds.add(1173302L);
        rangeIds.add(616741L);
        rangeIds.add(616825L);
        rangeIds.add(623170L);
        rangeIds.add(623275L);
        rangeIds.add(623276L);

        long start = System.currentTimeMillis();

        Set<Long> result1 = solution1.find(rangeIds);
        long end1 = System.currentTimeMillis();

        Set<Long> result2 = solution2.find(rangeIds);
        long end2 = System.currentTimeMillis();

        Set<Long> result3 = solution3.find(rangeIds);
        long end3 = System.currentTimeMillis();


        System.out.printf("%s\t%s\t%s", (end1 - start), (end2 - start), (end3 - start));
        System.out.println("result:");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
