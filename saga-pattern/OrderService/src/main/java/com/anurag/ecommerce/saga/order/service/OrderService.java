package com.anurag.ecommerce.saga.order.service;


import com.anurag.ecommerce.saga.order.entity.Order;
import com.anurag.ecommerce.saga.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order){
        order.setStatus("Success");
        Order savedOrder = orderRepository.save(order);
        kafkaTemplate.send("OrderPlaced", savedOrder);
        return savedOrder;
    }

    public Order findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
