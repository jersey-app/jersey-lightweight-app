package com.metaphor.interfaces.application;

import com.metaphor.sample.resource.SampleResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

public class Application extends ResourceConfig {

    public Application() {

        register(SampleResource.class);
    }
}
