package com.anurag.ecommerce.saga.order.messaging;


import com.anurag.ecommerce.saga.order.entity.Order;
import com.anurag.ecommerce.saga.order.model.PaymentNotification;
import com.anurag.ecommerce.saga.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class PaymentCancelledConsumer {
    @Autowired
    OrderRepository repository;

    @KafkaListener(topics = "PaymentFailedEvent", groupId = "myGroup1")
    public void updateInventory(PaymentNotification paymentNotification) {
        Order order = repository.findById(Long.valueOf(paymentNotification.getOrderId())).orElse(null);
        if (order != null) {
            order.setStatus("Cancelled");
            repository.save(order);
            log.info("Order Cancelled");
        }
        System.out.println("Received Message in group foo: " + paymentNotification);
    }
}
