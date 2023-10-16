package com.anurag.ecommerce.saga.order.repository;


import com.anurag.ecommerce.saga.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCustomerId(Long customerId);
}
