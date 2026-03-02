package com.order_service.service;

import com.order_service.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse getUserOrder();
    List<OrderResponse> getOrders();
}
