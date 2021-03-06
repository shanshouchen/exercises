package com.jason.exercises.netty.io.aio;

/**
 * Created by shanshouchen@weibangong.com on 24/11/2016
 *
 * @author shanshouchen
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 0;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port), "AIO-AsyncTimeClientHandler-001").start();
    }

}
