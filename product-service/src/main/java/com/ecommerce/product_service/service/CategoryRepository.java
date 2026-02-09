package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    // This method lets me search by the slug field automatically
    Optional<Category> findBySlug(String slug);
}
