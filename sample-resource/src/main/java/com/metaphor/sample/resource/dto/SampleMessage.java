package com.metaphor.sample.resource.dto;

import com.google.common.base.MoreObjects;
import com.metaphor.sample.resource.SampleResource;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import static org.glassfish.jersey.linking.InjectLink.Style.ABSOLUTE_PATH;

@InjectLinks(
        {@InjectLink(resource=SampleResource.class, rel = "self", style = ABSOLUTE_PATH)}
)
public final class SampleMessage {

    private String message;

    private SampleMessage() {
    }

    public String getMessage() {
        return message;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("message", message)
                .toString();
    }

    public static class Builder {

        private String message;

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public SampleMessage build() {
            SampleMessage sampleMessage = new SampleMessage();
            sampleMessage.message = message;
            return sampleMessage;
        }

    }
}
