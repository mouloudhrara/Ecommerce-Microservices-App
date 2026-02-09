package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.model.Product;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
//    void updateProduct(ProductRequest productRequest);
//    void deleteProduct(ProductRequest productRequest);
//    Product getProductById(String productRequest);
    List<ProductResponse> getAllProducts();
}
