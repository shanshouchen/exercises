package com.jason.exercises.netty.io.bio.p2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shanshouchen@weibangong.com on 24/11/2016
 *
 * @author shanshouchen
 */
public class TimeServer {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket;
            TimeServerHandlerExecutorPool executorPool = new TimeServerHandlerExecutorPool(50, 10000);

            //noinspection InfiniteLoopStatement
            while (true) {
                socket = server.accept();
                executorPool.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
            }
        }
    }
}

