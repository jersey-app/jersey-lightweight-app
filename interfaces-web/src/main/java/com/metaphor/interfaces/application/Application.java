package com.metaphor.interfaces.application;

import com.metaphor.order.client.binder.OrderBinder;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jersey.listing.JerseyApiDeclarationProvider;
import com.wordnik.swagger.jersey.listing.JerseyResourceListingProvider;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

    public Application() {
        setApplicationName("lightweight-app");

        packages("com.metaphor.sample.resource");
        register(DeclarativeLinkingFeature.class);
        register(ApiListingResourceJSON.class);
        register(JerseyApiDeclarationProvider.class);
        register(JerseyResourceListingProvider.class);

        register(new OrderBinder());
    }
}
