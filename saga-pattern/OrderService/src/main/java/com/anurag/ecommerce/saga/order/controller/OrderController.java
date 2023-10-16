package com.anurag.ecommerce.saga.order.controller;

import com.anurag.ecommerce.saga.order.entity.Order;
import com.anurag.ecommerce.saga.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return ResponseEntity.ok(service.saveOrder(order));
    }
    // more CRUD methods

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Order> getCustomerOrder(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.findByCustomerId(customerId));
    }
}
