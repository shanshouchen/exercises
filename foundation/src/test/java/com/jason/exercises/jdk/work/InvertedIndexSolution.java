package com.jason.exercises.jdk.work;

import com.jason.exercises.jdk.work.common.Paths;

import java.util.*;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class InvertedIndexSolution extends Resources {

    public InvertedIndexSolution() {
        super();
    }

    private Map<String, Set<Long>> index;
    private Set<Long> subIndex;

    public void createIndex(List<Paths> pathsList) {
        index = new HashMap<>();
        Paths temp;
        Iterator<Paths> pathsIterator = pathsList.iterator();
        while (pathsIterator.hasNext()) {
            temp = pathsIterator.next();
            String[] words = temp.getPath().split("/");
            for (String word : words) {
                if (!index.containsKey(word)) {
                    subIndex = new HashSet<>();
                    subIndex.add(temp.getRef());
                    index.put(word, subIndex);
                } else {
                    index.get(word).add(temp.getRef());
                }
            }
        }

    }

    @Override
    public Set<Long> find(Set<Long> set) {
        createIndex(data);
        Set<Long> result = new HashSet<>();
        for (Long id : set) {
            result.addAll(index.get(id + ""));
        }
        return result;
    }

    public static void main(String[] args) {
//        InvertedIndexSolution index = new InvertedIndexSolution();
//        long start = System.currentTimeMillis();
//        List<Paths> pathsList = index.createData("/Users/jason/Workspace/exercises/base/src/test/java/com/jason/exercises/jdk/work/paths.txt");
//        long end1 = System.currentTimeMillis();
//        index.createIndex(pathsList);
//        long end2 = System.currentTimeMillis();
//        Set<Long> set = index.find(499426L);
//        long end3 = System.currentTimeMillis();
//        System.out.printf("%s, %s, %s, %s\n", (end1 - start), (end2 - end1), (end3 - end2), (end3 - start));
//        System.out.println(set);
    }
}
