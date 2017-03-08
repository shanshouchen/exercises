package com.jason.exercises.web.jersey.server;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by shanshouchen@weibangong.com on 2017/2/17.
 */
@Singleton
@Path("server")
public class MyResources {
    @Path("{sub_path}")
    @GET
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces(MediaType.TEXT_PLAIN)
    public String getResource(@DefaultValue("shanshouchen") @PathParam("sub_path") String resourceName) {
        return "Hello " + resourceName;
    }
}
