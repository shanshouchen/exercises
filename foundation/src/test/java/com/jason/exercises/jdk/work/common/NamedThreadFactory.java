package com.jason.exercises.jdk.work.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/24.
 */
public class NamedThreadFactory  implements ThreadFactory {
    private static final AtomicInteger POOL_SEQ = new AtomicInteger(1);
    private static final AtomicInteger mThreadNum = new AtomicInteger(1);
    private final String mPrefix;
    private final ThreadGroup mGroup;

    public NamedThreadFactory() {
        this("pool-" + POOL_SEQ.getAndIncrement());
    }

    public NamedThreadFactory(String prefix) {
        mPrefix = prefix + "-thread-";
        SecurityManager s = System.getSecurityManager();
        mGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    public Thread newThread(Runnable runnable) {
        String name = mPrefix + mThreadNum.getAndIncrement();
        Thread thread = new Thread(mGroup, runnable, name);
        return thread;
    }
}
