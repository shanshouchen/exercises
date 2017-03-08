package com.jason.exercises.netty.io.bio.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by shanshouchen@weibangong.com on 24/11/2016
 *
 * @author shanshouchen
 */
public class TimeServerHandler implements Runnable {
    Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime;
            String body;
            while (true) {
                body = reader.readLine();
                if (body == null) break;
                System.out.println("The time server receive order:" + body);
                currentTime = "TIME".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                writer.println(currentTime);
            }
        } catch (Exception e) {
            if (reader != null) try {
                reader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            if (writer != null) writer.close();

            if (this.socket != null) try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
