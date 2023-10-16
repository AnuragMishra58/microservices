package com.anurag.ecommerce.saga.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    private Long customerId;
    private Long quantity;
    private String status;
}