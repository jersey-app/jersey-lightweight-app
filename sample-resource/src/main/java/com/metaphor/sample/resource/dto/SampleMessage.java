package com.metaphor.sample.resource.dto;

import com.google.common.base.MoreObjects;

public class SampleMessage {

    private String message;

    protected SampleMessage() {
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
