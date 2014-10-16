package com.metaphor.resource;

import com.metaphor.interfaces.application.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderResourceTest extends JerseyTest {
    @Override
    protected ResourceConfig configure() {
        return new Application();
    }

    @Test
    public void testGetOrders() throws Exception {
        Response response = target("orders/{orderNumber}")
                .resolveTemplate("orderNumber", "123456")
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));
    }
}