package com.anurag.ecommerce.saga.inventory.messaging;


import com.anurag.ecommerce.saga.inventory.entity.Inventory;
import com.anurag.ecommerce.saga.inventory.model.Order;
import com.anurag.ecommerce.saga.inventory.model.PaymentNotification;
import com.anurag.ecommerce.saga.inventory.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class InventoryEventConsumer {
    @Autowired
    InventoryRepository repository;
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @KafkaListener(topics = "OrderPlaced", groupId = "myGroup")
    public void updateInventory(Order order) {
        Inventory inventory = repository.findById(order.getProductId()).orElse(null);
        if (inventory != null) {
            inventory.setQuantity(inventory.getQuantity() - order.getQuantity());
            repository.save(inventory);
            order.setTotalAmount(inventory.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
            log.info("Stock Reserved");
            kafkaTemplate.send("StockReservedEvent", order);
        }
        System.out.println("Received Message in group foo: " + order);
    }
}
