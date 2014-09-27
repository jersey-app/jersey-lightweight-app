package com.metaphor.sample.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/sample")
public class SampleResource {

    @GET
    @Path("/")
    public String get() {
        return "sample";
    }
}
