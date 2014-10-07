package com.metaphor.order.resource;

import com.metaphor.order.client.model.Order;
import com.metaphor.order.service.OrderService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    private final OrderService service;

    @Inject
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GET
    @Path("{numbers}")
    public List<Order> getOrders(@PathParam("numbers") String numbers) {
        return service.orders(numbers);
    }
}
