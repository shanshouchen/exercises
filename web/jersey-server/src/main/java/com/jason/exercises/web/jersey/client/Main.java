package com.jason.exercises.web.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/17.
 */
public class Main {

    public static void main(String[] args) {
        ClientConfig cc = new DefaultClientConfig();
        cc.getProperties().put(ClientConfig.PROPERTY_CONNECT_TIMEOUT, 10 * 1000);
        Client client = Client.create(cc);

        WebResource resource = client.resource("http://localhost:8080/server/abc");

        String str = resource
                .accept(MediaType.TEXT_PLAIN)
                .type(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println("Response:" + str);
    }

}
