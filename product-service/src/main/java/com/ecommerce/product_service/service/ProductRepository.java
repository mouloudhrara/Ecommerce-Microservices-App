package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
// is used to tell spring boot how to talk to postgres
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
