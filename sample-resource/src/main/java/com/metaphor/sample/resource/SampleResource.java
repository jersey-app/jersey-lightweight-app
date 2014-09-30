package com.metaphor.sample.resource;

import com.metaphor.sample.resource.dto.SampleMessage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
public class SampleResource {

    @GET
    @Path("/")
    public SampleMessage get() {
        return SampleMessage.builder().withMessage("sample").build();
    }
}
