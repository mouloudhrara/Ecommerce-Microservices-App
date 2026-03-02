package com.order_service.dto;

import com.order_service.model.ProductDetails;
import com.order_service.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String id;
    private String userId;
    private String email;
    private Integer amount;
    private Status status;
    private ProductDetails productDetails;
}
