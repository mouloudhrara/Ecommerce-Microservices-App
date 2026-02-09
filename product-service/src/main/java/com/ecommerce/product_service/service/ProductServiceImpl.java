package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    // for logging errors, warnings and for debugging
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    // I defined the Contract: By extending MongoRepository<Product, String>, I tell Spring:
    // "I need a tool that can Save, Delete, and Find Product objects, and their ID is a String."
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setShortDescription(productRequest.getShortDescription());
        product.setImages(productRequest.getImages());
        product.setColors(productRequest.getColors());
        product.setSizes(productRequest.getSizes());
        product.setCategory(productRequest.getCategory());
        productRepository.save(product);
        log.info("Product {} has been created", product.getId());
    }

//    @Override
//    public void updateProduct(ProductRequest productRequest) {
//
//    }

//    @Override
//    public void deleteProduct(ProductRequest productRequest) {
//    }

//    @Override
//    public Product getProductById(ProductRequest productRequest) {
//        return null;
//    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            ProductResponse productResponse = new ProductResponse(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getShortDescription(),
                    product.getPrice(),
                    product.getImages(),
                    product.getColors(),
                    product.getSizes(),
                    product.getCreatedDate(),
                    product.getUpdatedDate(),
                    product.getCategory()
            );
            productResponses.add(productResponse);
        }
        return productResponses;
    }
}
