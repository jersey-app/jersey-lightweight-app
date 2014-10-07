package com.metaphor.order.resource;

import com.google.common.collect.ImmutableList;
import com.metaphor.order.client.model.Order;
import com.metaphor.order.service.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("order")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="order", description = "order resource")
public class OrderResource {

    private final OrderService service;

    @Inject
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GET
    @Path("/{numbers}")
    @ApiOperation("get orders via some orders' number")
    public List<Order> getOrders(@PathParam("numbers")
                                 @ApiParam(value = "some orders' number", allowMultiple = true) String numbers) {
        return service.orders(numbers);
    }

    @GET
    @Path("/cancelableOrder/{numbers}")
    @ApiOperation("Practice: get some orders that can be cancelled, " +
            "that means you can cancel order only when " +
            "the order's status is COMMIT or the status is ACCEPTED " +
            "but the day after order time is still in two days")
    public List<Order> canCancelledOrders(@PathParam("numbers")
                                          @ApiParam(value = "some can be cancelled orders' number", allowMultiple = true) String numbers) {

        return ImmutableList.of();
    }
}
