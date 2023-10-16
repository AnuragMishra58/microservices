package com.anurag.ecommerce.saga.payment.messaging;


import com.anurag.ecommerce.saga.payment.entity.Payment;
import com.anurag.ecommerce.saga.payment.model.Order;
import com.anurag.ecommerce.saga.payment.model.PaymentNotification;
import com.anurag.ecommerce.saga.payment.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class StockReservedEventConsumer {
    @Autowired
    PaymentRepository repository;
    @Autowired
    private KafkaTemplate<String, PaymentNotification> kafkaTemplate;

    @KafkaListener(topics = "StockReservedEvent", groupId = "myGroup")
    public void makePayment(Order order) {
        Random random = new Random();
        PaymentNotification paymentNotification = PaymentNotification.builder().email("test@test.com").customerName("Raju").orderId(order.getId().toString()).build();
        if (random.nextBoolean()) {
            log.info("Payment Success");
            Payment payment = Payment.builder().amount(order.getTotalAmount()).customerId(order.getCustomerId()).status("SUCCESS").build();
            repository.save(payment);
            kafkaTemplate.send("PaymentSuccessEvent", paymentNotification);
        }else {
            log.info("Payment Failed");
            kafkaTemplate.send("PaymentFailedEvent", paymentNotification);
        }

        System.out.println("Received Message in group foo: " + order);
    }
}
