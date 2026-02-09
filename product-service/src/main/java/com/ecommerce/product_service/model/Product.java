package com.ecommerce.product_service.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Document :for NoSQL db

@Entity(name = "t_products")
@EntityListeners(AuditingEntityListener.class) // 1. Activates the automatic date handling
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Integer id;
    private String name;
    private String description;
    private String shortDescription;
    private BigDecimal price;
    // SQL cannot store arrays in a cell. This creates a separate table for sizes.
    @ElementCollection
    @CollectionTable(name = "product_sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "size")
    private List<String> sizes;
    @ElementCollection
    @CollectionTable(name = "product_colors", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "color")
    private List<String> colors;
    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "image_url")
    private List<String> images;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;

    public Product() {}
    public Product(Integer id, String name, String description,String shortDescription, BigDecimal price, List<String> sizes, List<String> colors, List<String> images, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.price = price;
        this.sizes = sizes;
        this.colors = colors;
        this.images = images;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
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
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    @ManyToOne(fetch = FetchType.LAZY) // Lazy means "Don't load the category unless I specifically ask for it"
    @JoinColumn(name = "category_id") // This creates the foreign key column in the database
    private Category category;
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }
}
