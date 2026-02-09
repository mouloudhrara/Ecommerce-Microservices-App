package com.ecommerce.product_service.dto;

import java.util.Objects;

public class CategoryRequest {
    private String name;
    private String slug;

    public CategoryRequest() {};

    public CategoryRequest(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryRequest that = (CategoryRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(slug, that.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, slug);
    }
}
