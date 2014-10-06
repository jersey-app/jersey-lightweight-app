package com.metaphor.sample.resource;

import com.metaphor.sample.resource.dto.SampleMessage;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SampleResourceTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(SampleResource.class);
    }

    @Test
    public void should_get_message_with_json_format() throws Exception {
        SampleMessage message = target("sample")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(SampleMessage.class);

        assertThat(message.getMessage(), is("sample"));
    }
}