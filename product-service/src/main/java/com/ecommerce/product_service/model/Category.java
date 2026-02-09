package com.ecommerce.product_service.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String slug;
    // "mappedBy" tells Hibernate: "Go look at the 'category' field in the Product class to understand this link."
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

    public Category() {}
    public Category(String name, String slug) {
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
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
