package com.metaphor.sample.resource;

import com.metaphor.sample.resource.dto.SampleMessage;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "/sample", description = "A sample of jersey application")
public class SampleResource {

    @GET
    @ApiOperation(value="just to test the sample api")
    public SampleMessage get() {
        return SampleMessage.builder().withMessage("sample").build();
    }
}
