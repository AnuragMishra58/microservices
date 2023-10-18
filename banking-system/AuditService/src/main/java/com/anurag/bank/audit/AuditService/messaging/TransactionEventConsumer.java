package com.anurag.bank.audit.AuditService.messaging;


import com.anurag.bank.audit.AuditService.entity.AuditRecord;
import com.anurag.bank.audit.AuditService.repository.AuditRecordRepository;
import lombok.extern.slf4j.Slf4j;
import com.anurag.bank.audit.AuditService.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class TransactionEventConsumer {
    @Autowired
    AuditRecordRepository repository;

    @KafkaListener(topics = {"TransactionFailedEvent", "TransactionCompletedEvent"}, groupId = "myGroup1")
    public void createAudit(Transaction transaction) {
        AuditRecord auditRecord = AuditRecord.builder().auditDate(new Date()).eventType("Transaction")
                .eventData(transaction.toString()).build();
        repository.save(auditRecord);
        System.out.println("Received Message in group foo: " + transaction);
    }
}
