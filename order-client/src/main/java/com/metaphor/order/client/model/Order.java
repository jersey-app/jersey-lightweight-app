package com.metaphor.order.client.model;

import com.google.common.base.MoreObjects;
import org.joda.time.DateTime;

public class Order {
    private String number;
    private DateTime time;
    private OrderStatus status;

    public String getNumber() {
        return number;
    }

    public DateTime getTime() {
        return time;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String number;
        private DateTime time;
        private OrderStatus status;

        public Builder withOld(Order oldOrder) {
            this.number = oldOrder.number;
            this.time = oldOrder.time;
            this.status = oldOrder.status;
            return this;
        }

        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withTime(DateTime time) {
            this.time = time;
            return this;
        }

        public Builder withStatus(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Order build(){
            Order order = new Order();
            order.status = this.status;
            order.number = this.number;
            order.time = this.time;

            return order;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("number", number)
                .add("time", time)
                .add("status", status)
                .toString();
    }
}
