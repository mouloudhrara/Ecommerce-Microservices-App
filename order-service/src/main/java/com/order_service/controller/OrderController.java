package com.order_service.controller;

import com.order_service.dto.OrderResponse;
import com.order_service.model.Order;
import com.order_service.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("api/user-order")
    Order getUserOrder(){
        Order order = new Order();
        return order;
    }
    @GetMapping("api/orders")
    List<OrderResponse> getOrders(){
        return orderService.getOrders();
    }
}
