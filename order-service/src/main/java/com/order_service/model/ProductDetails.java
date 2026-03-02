package com.order_service.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    @NotBlank
    private String name;
    @NotNull
    private Integer quantity;
    @NotNull
    private BigDecimal price;
}
