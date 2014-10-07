package com.metaphor.order.client;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.metaphor.order.client.factory.MockOrder;
import com.metaphor.order.client.factory.MockOrderRemoteService;
import com.metaphor.order.client.model.Order;
import com.metaphor.order.client.model.OrderStatus;

import javax.inject.Inject;
import java.util.List;

public class OrderClient {

    private final MockOrderRemoteService service;

    @Inject
    public OrderClient(MockOrderRemoteService service) {
        this.service = service;
    }

    public List<Order> getOrders(ImmutableSet<String> orderNumbers){
        return Lists.transform(service.orders(orderNumbers), toOrder());
    }

    private Function<MockOrder, Order> toOrder() {
        return new Function<MockOrder, Order>() {
            @Override
            public Order apply(MockOrder mockOrder) {
                return Order.builder()
                        .withNumber(mockOrder.getNumber())
                        .withTime(mockOrder.getTime())
                        .withStatus(OrderStatus.valueOf(mockOrder.getStatus()))
                        .build();
            }
        };
    }
}
