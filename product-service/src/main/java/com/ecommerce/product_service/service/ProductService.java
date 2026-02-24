package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(ProductRequest productRequest, Integer id);
    void deleteProduct(Integer id);
    ProductResponse getProductById(Integer id);
    List<ProductResponse> getAllProducts(String sort, String category, String search);
}
