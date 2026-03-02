package com.order_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.order_service.model.ProductDetails;
import com.order_service.model.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    //@JsonProperty("user_id")
    @NotBlank
    private String userId;
    @NotBlank
    private String email;
    @NotNull
    private Integer amount;
    @NotNull
    private Status status;
    @Valid
    @NotNull
    private ProductDetails productDetails;
}
