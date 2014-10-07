package com.metaphor.order.client.factory;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.ImmutableList.of;

public class MockOrderRemoteService {
    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    private ImmutableList<MockOrder> orders = of(
            newOrder("123456", "COMMIT", "2014-10-09 18:00"),
            newOrder("123457", "ACCEPTED", "2014-10-08 18:00"),
            newOrder("123458", "ACCEPTED", "2014-10-01 18:00"),
            newOrder("123459", "COMPLETED", "2014-10-09 18:00")
    );

    private MockOrder newOrder(String number, String status, String orderTime){
        DateTime time = DEFAULT_FORMATTER.parseDateTime(orderTime);
        return MockOrder.builder()
                .withNumber(number)
                .withStatus(status)
                .withTime(time)
                .build();
    }

    public ImmutableList<MockOrder> orders(ImmutableSet<String> orderNumbers){
        return from(orders).filter(in(orderNumbers)).toList();
    }

    private Predicate<MockOrder> in(final ImmutableSet<String> orderNumbers) {
        return new Predicate<MockOrder>() {
            @Override
            public boolean apply(MockOrder order) {
                return orderNumbers.contains(order.getNumber());
            }
        };
    }
}
