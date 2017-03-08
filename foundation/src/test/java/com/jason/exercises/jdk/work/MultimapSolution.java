package com.jason.exercises.jdk.work;

import com.google.common.collect.ArrayListMultimap;
import com.jason.exercises.jdk.work.common.Paths;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class MultimapSolution extends Resources {

    public MultimapSolution() {
        super();
    }

    protected Set<Long> getRangeChildDepts(Set<Long> rangeIds) {
        Set<Long> rangeToDeptIds = new LinkedHashSet<>();
        List<Paths> pathsList = data;
        ArrayListMultimap<Long, Long> pathRefMapList = ArrayListMultimap.create();
        for (Paths paths : pathsList) {
            for (String path : paths.getPath().split("/")) {
                if ("null".equals(path)) {
                    continue;
                }
                pathRefMapList.put(Long.valueOf(path), paths.getRef());
            }
        }
        for (Long rangeId : rangeIds) {
            List<Long> refList = pathRefMapList.get(rangeId);
            if (CollectionUtils.isNotEmpty(refList)) {
                rangeToDeptIds.addAll(refList);
            }
        }
        return rangeToDeptIds;
    }

    @Override
    public Set<Long> find(Set<Long> set) {
        return getRangeChildDepts(set);
    }
}
