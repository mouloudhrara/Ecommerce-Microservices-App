package com.ecommerce.product_service.dto;

import com.ecommerce.product_service.model.Category;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private String shortDescription;
    private List<String> images;
    private List<String> sizes;
    private List<String> colors;
    private Category category;
    public ProductRequest(){};
    public ProductRequest(String name, String description, String shortDescription, BigDecimal price,  Integer categoryId, List<String> images, List<String> sizes, List<String> colors, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.shortDescription = shortDescription;
        this.images = images;
        this.sizes = sizes;
        this.colors = colors;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    public List<String> getSizes() {
        return sizes;
    }
    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }
    public List<String> getColors() {
        return colors;
    }
    public void setColors(List<String> colors) {
        this.colors = colors;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRequest that = (ProductRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
