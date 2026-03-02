package com.order_service.service;

import com.order_service.dto.OrderResponse;
import com.order_service.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public OrderResponse getUserOrder() {
        return null;
    }

    @Override
    public List<OrderResponse> getOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Order order : orders) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(order.getId());
            orderResponse.setUserId(order.getUserId());
            orderResponse.setEmail(order.getEmail());
            orderResponse.setAmount(order.getAmount());
            orderResponse.setStatus(order.getStatus());
            orderResponse.setProductDetails(order.getProduct());
            orderResponseList.add(orderResponse);
        }
        return  orderResponseList;
    }
}
