package com.metaphor.order.resource;

import com.google.common.collect.ImmutableList;
import com.metaphor.order.client.model.Order;
import com.metaphor.order.service.OrderService;
import com.wordnik.swagger.annotations.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("order")
@Produces(MediaType.APPLICATION_JSON)
@Api(value="/order", description = "order resource")
public class OrderResource {

    private final OrderService service;

    @Inject
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GET
    @Path("/{numbers}")
    @ApiOperation(value = "get orders via some orders' number", responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid numbers supplied"),
            @ApiResponse(code = 404, message = "Order not found") })
    public List<Order> getOrders(@PathParam("numbers")
                                 @ApiParam(value = "some orders' number", allowMultiple = true) String numbers) {
        return service.orders(numbers);
    }

    @GET
    @Path("/cancelableOrder/{numbers}")
    @ApiOperation(value="get some orders can be cancelled,",
            notes = "that means you can cancel order only when " +
            "the order's status is COMMIT or the status is ACCEPTED " +
            "but the day after order time is still in two days",
            responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid numbers supplied"),
            @ApiResponse(code = 404, message = "Order not found") })
    public List<Order> canCancelledOrders(@ApiParam(value = "some can be cancelled orders' number", allowMultiple = true)
                                          @PathParam("numbers") String numbers) {

        return ImmutableList.of();
    }
}
