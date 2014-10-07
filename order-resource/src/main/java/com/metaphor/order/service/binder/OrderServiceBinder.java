package com.metaphor.order.service.binder;

import com.metaphor.order.service.OrderService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class OrderServiceBinder extends AbstractBinder{
    @Override
    protected void configure() {
        bindAsContract(OrderService.class);
    }
}
