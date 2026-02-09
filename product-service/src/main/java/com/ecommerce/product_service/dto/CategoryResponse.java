package com.ecommerce.product_service.dto;

import java.util.Objects;

public class CategoryResponse {
    private Integer id;
    private String name;
    private String slug;

    public CategoryResponse() {
    }
    public CategoryResponse(Integer id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
        return "CategoryResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoryResponse that = (CategoryResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(slug, that.slug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slug);
    }
}

