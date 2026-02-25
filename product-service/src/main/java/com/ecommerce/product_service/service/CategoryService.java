package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.CategoryRequest;
import com.ecommerce.product_service.dto.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CategoryService {
    void  createCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> getAllCategories();
    CategoryResponse updateCategory(Integer id, CategoryRequest categoryRequest);
    void deleteCategory(Integer id);
}
