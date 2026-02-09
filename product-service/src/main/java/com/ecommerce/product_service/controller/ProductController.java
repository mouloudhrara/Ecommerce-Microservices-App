package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    // Manual Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // @RequestBody tell spring to look at the body of the request not the url
    // take JSON and deserialize it into Java Object
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
