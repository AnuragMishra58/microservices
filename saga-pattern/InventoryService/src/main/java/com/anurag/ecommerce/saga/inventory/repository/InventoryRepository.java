package com.anurag.ecommerce.saga.inventory.repository;


import com.anurag.ecommerce.saga.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
