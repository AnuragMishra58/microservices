package com.anurag.ecommerce.saga.inventory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long quantity;
    private BigDecimal price;
}