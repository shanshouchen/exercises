package com.jason.exercises.netty.io.nio;

import java.io.IOException;

/**
 * Created by shanshouchen@weibangong.com on 24/11/2016
 *
 * @author shanshouchen
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();

    }


}
