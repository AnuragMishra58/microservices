package com.anurag.bank.frauddetection.messaging;


import com.anurag.bank.frauddetection.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class TransactionCompletedConsumer {

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    @KafkaListener(topics = "TransactionCompletedEvent", groupId = "myGroup")
    public void analyzeTransaction(Transaction transaction) {

        if (transaction.getAmount().compareTo(BigDecimal.valueOf(50000)) > 0) {
            log.info("SuspiciousActivityEvent");
            kafkaTemplate.send("SuspiciousActivityEvent", transaction);
        }

        log.info("Received Message in group foo: " + transaction);
    }
}
