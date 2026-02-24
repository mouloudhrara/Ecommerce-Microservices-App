package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.exception.BadRequest;
import com.ecommerce.product_service.exception.ResourceNotFound;
import com.ecommerce.product_service.model.Category;
import com.ecommerce.product_service.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    // for logging errors, warnings and for debugging
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    // I defined the Contract: By extending MongoRepository<Product, String>, I tell Spring:
    // "I need a tool that can Save, Delete, and Find Product objects, and their ID is a String."
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void createProduct(ProductRequest productRequest) {
        // check if colors list is empty or null
        if(productRequest.getColors() == null || productRequest.getColors().isEmpty()) {
            throw new BadRequest(" a product must have at least one color");
        }
        // check if images map is null or empty
        if(productRequest.getImages() == null || productRequest.getImages().isEmpty()) {
            throw new BadRequest(" a product must have at least one image");
        }
        // check if every color has a corresponding image in the map
        productRequest.getColors().stream().filter(color -> !productRequest.getImages().containsKey(color)).findFirst()
                .ifPresent(missingColor -> {
                    throw new BadRequest(" Missing image url for the color"+ missingColor);
                });

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setShortDescription(productRequest.getShortDescription());
        product.setImages(productRequest.getImages());
        product.setColors(productRequest.getColors());
        product.setSizes(productRequest.getSizes());
        // find the category by its unique slug
        Category category = categoryRepository.findBySlug(productRequest.getCategorySlug())
                .orElseThrow(()->new ResourceNotFound("Category not found with slug:"+ productRequest.getCategorySlug()));
//        product.setCategory(productRequest.getCategory());
        product.setCategory(category);
        productRepository.save(product);
        log.info("Product {} has been created", product.getId());
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest, Integer id) {
        // check if colors list is empty or null
        if(productRequest.getColors() == null || productRequest.getColors().isEmpty()) {
            throw new BadRequest(" a product must have at least one color");
        }
        // check if images map is null or empty
        if(productRequest.getImages() == null || productRequest.getImages().isEmpty()) {
            throw new BadRequest(" a product must have at least one image");
        }
        // check if every color has a corresponding image in the map
        productRequest.getColors().stream().filter(color -> !productRequest.getImages().containsKey(color)).findFirst()
                .ifPresent(missingColor -> {
                    throw new BadRequest(" Missing image url for the color"+ missingColor);
                });
        // find the category by its unique slug
        Category category = categoryRepository.findBySlug(productRequest.getCategorySlug())
                .orElseThrow(()->new ResourceNotFound("Category not found with slug:"+ productRequest.getCategorySlug()));
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFound("Product not found with id:"+ id));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        product.setShortDescription(productRequest.getShortDescription());
        product.setImages(productRequest.getImages());
        product.setColors(productRequest.getColors());
        product.setSizes(productRequest.getSizes());
        product.setCategory(category);
        productRepository.save(product);
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
                product.getCategory().getSlug()
        );
        return productResponse;
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Product not found with id:"+ id));
        productRepository.delete(product);
        log.info("Product {} has been deleted", product.getId());
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFound("Product not found with id:" + id));
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
                product.getCategory().getSlug()
        );
        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts(String sort, String category, String search) {
            List<Product> products;
            if(category != null){
                products = productRepository.findAllByCategorySlug(category);
            }
            else if(search != null){
                products = productRepository.findByNameContainingIgnoreCase(search);
            }
            else{
                if(sort == null){
                    sort = "default";
                }
                switch (sort) {
                    case "highest_price":
                        products = productRepository.findAllByOrderByPriceDesc();
                        break;
                    case "lowest_price":
                        products =  productRepository.findAllByOrderByPriceAsc();
                        break;
                    case "oldest":
                        products = productRepository.findAllByOrderByCreatedDateAsc();
                        break;
                    case "latest":
                        products = productRepository.findAllByOrderByCreatedDateDesc();
                        break;
                    default:
                        products = productRepository.findAll();
                        break;
                }
            }
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
                        product.getCategory().getSlug()
                );
                productResponses.add(productResponse);
            }
            return productResponses;
    }
}
