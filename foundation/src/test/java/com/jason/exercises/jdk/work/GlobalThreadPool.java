package com.jason.exercises.jdk.work;

import com.jason.exercises.jdk.work.common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class GlobalThreadPool {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(8, new NamedThreadFactory("GlobalThreadPool"));

    public static ExecutorService getThreadPool() {
        return EXECUTOR_SERVICE;
    }
}
