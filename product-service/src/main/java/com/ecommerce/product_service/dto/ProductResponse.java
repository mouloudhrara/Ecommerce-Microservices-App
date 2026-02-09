package com.ecommerce.product_service.dto;

import com.ecommerce.product_service.model.Category;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private String shortDescription;
    private BigDecimal price;
    private List<String> images;
    private List<String> colors;
    private List<String> sizes;
    private Date createdAt;
    private Date updatedAt;
    private Category category;
    public ProductResponse() {
    }
    public ProductResponse(int id,String name, String description, String shortDescription, BigDecimal price,  List<String> images, List<String> colors, List<String> sizes, Date createdAt, Date updatedAt, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.price = price;
        this.images = images;
        this.colors = colors;
        this.sizes = sizes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    public List<String> getColors() {
        return colors;
    }
    public void setColors(List<String> colors) {
        this.colors = colors;
    }
    public List<String> getSizes() {
        return sizes;
    }
    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "ProductResponse{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductResponse that = (ProductResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
