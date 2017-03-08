package com.jason.exercises.web.jersey.server;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/17.
 */
public class Main {
    public static void main(String[] args) {
        URI uri = UriBuilder.fromUri("http://localhost").port(8080).build();
        ResourceConfig rc = new PackagesResourceConfig("com.jason.exercises.web.jersey.server");
        try {
            HttpServer server = GrizzlyServerFactory.createHttpServer(uri, rc);
            server.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
