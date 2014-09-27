package com.metaphor.interfaces.web;

import com.metaphor.sample.resource.SampleResource;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

    public Application() {

        register(SampleResource.class);
    }
}
