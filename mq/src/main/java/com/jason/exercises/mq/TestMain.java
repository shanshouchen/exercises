package com.jason.exercises.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by shanshouchen@weibangong.com on 2017/1/23.
 */
public class TestMain {
    public static void main(String[] args) throws IOException, TimeoutException {

        for (int i = 0; i < 100; i++) {
            hash(1);
        }
    }
//    static int hash(int h) {
//        h ^= (h >>> 20) ^ (h >>> 12);
//        return h ^ (h >>> 7) ^ (h >>> 4);
//    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
