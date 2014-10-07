package com.metaphor.order.client.binder;

import com.metaphor.order.client.OrderClient;
import com.metaphor.order.client.factory.MockOrderRemoteService;
import com.metaphor.order.client.factory.OrderFactory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class OrderBinder extends AbstractBinder{
    @Override
    protected void configure() {
        bindFactory(OrderFactory.class).to(MockOrderRemoteService.class);

        bindAsContract(OrderClient.class);
    }
}
