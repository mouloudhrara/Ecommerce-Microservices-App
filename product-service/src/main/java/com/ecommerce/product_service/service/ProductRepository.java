package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// is used to tell spring boot how to talk to postgres
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findAllByOrderByCreatedDateAsc();
    List<Product> findAllByOrderByCreatedDateDesc();
    List<Product> findAllByCategorySlug(String  categorySlug);
    List<Product> findByNameContainingIgnoreCase(String name);
}
