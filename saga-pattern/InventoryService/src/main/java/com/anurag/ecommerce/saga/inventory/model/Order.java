package com.anurag.ecommerce.saga.inventory.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class Order implements Serializable {
    private Long id;
    private Long productId;
    private Long customerId;
    private Long quantity;
    private String status;
    private BigDecimal totalAmount;
}