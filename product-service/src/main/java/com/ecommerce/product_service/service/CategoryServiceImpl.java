package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.CategoryRequest;
import com.ecommerce.product_service.dto.CategoryResponse;
import com.ecommerce.product_service.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setSlug(categoryRequest.getSlug());
        categoryRepository.save(category);
        log.info("Category created successfully", category.getId());
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponse> responses = new ArrayList<>();
        for(Category category : categories) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(category.getId());
            categoryResponse.setName(category.getName());
            categoryResponse.setSlug(category.getSlug());
            responses.add(categoryResponse);
        }
        return responses;
    }
}
