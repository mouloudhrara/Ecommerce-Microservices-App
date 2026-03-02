package com.order_service.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String email;
    @NotNull
    private Integer amount;
    @NotNull
    private Status status;
    @NotNull
    @Valid
    private ProductDetails product;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
}
