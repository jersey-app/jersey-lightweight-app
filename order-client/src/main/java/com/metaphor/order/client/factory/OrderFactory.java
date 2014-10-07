package com.metaphor.order.client.factory;


import org.glassfish.hk2.api.Factory;

public class OrderFactory implements Factory<MockOrderRemoteService> {

    @Override
    public MockOrderRemoteService provide() {
        return new MockOrderRemoteService();
    }

    @Override
    public void dispose(MockOrderRemoteService instance) {
    }
}
