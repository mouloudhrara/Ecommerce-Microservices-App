package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.CategoryRequest;
import com.ecommerce.product_service.dto.CategoryResponse;
import com.ecommerce.product_service.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getCategories() {
        return categoryService.getAllCategories();
    }
}
