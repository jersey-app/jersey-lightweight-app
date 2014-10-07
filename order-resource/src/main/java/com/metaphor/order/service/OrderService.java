package com.metaphor.order.service;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.metaphor.order.client.OrderClient;
import com.metaphor.order.client.model.Order;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.collect.FluentIterable.from;

public class OrderService {
    private static final Splitter COMMA_SPLITTER = Splitter.on(',').omitEmptyStrings().trimResults();
    private final OrderClient client;

    @Inject
    public OrderService(OrderClient client) {
        this.client = client;
    }

    public List<Order> orders(String numbers) {
        ImmutableSet<String> numberSet = from(COMMA_SPLITTER.split(numbers)).toSet();
        return client.getOrders(numberSet);
    }
}
