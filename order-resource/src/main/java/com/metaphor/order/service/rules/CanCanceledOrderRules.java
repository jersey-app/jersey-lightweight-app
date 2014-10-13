package com.metaphor.order.service.rules;

import com.google.common.base.Predicate;
import com.metaphor.order.client.model.Order;
import com.metaphor.order.client.model.OrderStatus;

import javax.annotation.Nullable;

import static com.google.common.base.Predicates.and;
import static com.google.common.base.Predicates.or;

public class CanCanceledOrderRules {
    public static Predicate<Order> canCancledOrder() {
        return or(
                justCommit(),
                and(haveAccepted(), notBeyondTwoDays())
               );
    }

    private static Predicate<Order> notBeyondTwoDays() {
        return new Predicate<Order>() {
            @Override
            public boolean apply(@Nullable Order order) {
                return order.getTime().plusDays(2).isAfterNow();
            }
        };
    }

    private static Predicate<Order> haveAccepted() {
        return new Predicate<Order>() {
            @Override
            public boolean apply(@Nullable Order order) {
                return order.getStatus() == OrderStatus.ACCEPTED;
            }
        };
    }

    private static Predicate<Order> justCommit() {
        return new Predicate<Order>() {
            @Override
            public boolean apply(@Nullable Order order) {
                return order.getStatus() == OrderStatus.COMMIT;
            }
        };
    }
}
