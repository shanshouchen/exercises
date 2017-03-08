package com.jason.exercises.jdk.work;

import com.jason.exercises.jdk.work.common.Paths;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class ThreadPoolSolution extends Resources {

    public ThreadPoolSolution() {
        super();
    }

    public Set<Long> getRangeChildDepts(Set<Long> rangeIds) {
        Set<Long> rangeToDeptIds = new LinkedHashSet<>();
        try {
            List<Paths> pathsList = data;

            if (CollectionUtils.isNotEmpty(pathsList)
                    && CollectionUtils.isNotEmpty(rangeIds)) {
                if (pathsList.size() > 2000 && rangeIds.size() > 10) {
                    CountDownLatch countDownLatch = new CountDownLatch(rangeIds.size());
                    for (Long rangeId : rangeIds) {
                        GlobalThreadPool.getThreadPool().execute(new RangeToDeptIdThread(rangeToDeptIds, pathsList, rangeId, countDownLatch));
                    }
                    countDownLatch.await();
                } else {
                    for (Long rangeId : rangeIds) {
                        for (Paths paths : pathsList) {
                            if (PathUtil.contains2(paths.getPath(), rangeId)) {
                                rangeToDeptIds.add(paths.getRef());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rangeToDeptIds;
    }

    public static boolean contains2(String paths, Long rangeId) {
        if (StringUtils.isNotEmpty(paths)) {
            for (String item : paths.split("/")) {
                if ("null".equals(item)) {
                    continue;
                }
                if (Long.valueOf(item) == rangeId.longValue()) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Set<Long> find(Set<Long> set) {
        return getRangeChildDepts(set);
    }

    private static class RangeToDeptIdThread implements Runnable {
        private Set<Long> rangeToDeptIds;
        private List<Paths> pathsList;
        private Long rangeId;
        private CountDownLatch countDownLatch;

        public RangeToDeptIdThread(Set<Long> rangeToDeptIds, List<Paths> pathsList, Long rangeId, CountDownLatch countDownLatch) {
            this.rangeToDeptIds = rangeToDeptIds;
            this.pathsList = pathsList;
            this.rangeId = rangeId;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                for (Paths paths : pathsList) {
                    if (contains2(paths.getPath(), rangeId)) {
                        rangeToDeptIds.add(paths.getRef());
                    }
                }
            } finally {
                countDownLatch.countDown();
            }

        }
    }
}
