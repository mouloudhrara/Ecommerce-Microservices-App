package com.order_service.service;

import com.order_service.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
