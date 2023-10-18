package com.anurag.bank.transaction.service;

import com.anurag.bank.transaction.entity.Transaction;
import com.anurag.bank.transaction.feignclient.AccountClient;
import com.anurag.bank.transaction.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class TransactionService {
    @Autowired
    TransactionRepository repository;

    @Autowired
    AccountClient accountClient;

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    public Transaction createTransaction(Transaction transaction) {
        transaction.setStatus("INITIATED");
        if ("CREDIT".equalsIgnoreCase(transaction.getTransactionType())) {
            accountClient.creditAccount(transaction.getAccountNumber(), transaction.getAmount());
        } else {
            accountClient.debitAccount(transaction.getAccountNumber(), transaction.getAmount());
        }
        Random random = new Random();
        if (random.nextBoolean()) {
            log.info("Transaction Completed");
            transaction.setStatus("COMPLETED");
            kafkaTemplate.send("TransactionCompletedEvent", transaction);
        } else {
            log.info("Transaction Failed");
            transaction.setStatus("FAILED");
            kafkaTemplate.send("TransactionFailedEvent", transaction);
        }

        return repository.save(transaction);
    }


    public Transaction completeTransaction(Long transactionId) {
        Transaction transaction = repository.findById(transactionId).orElse(null);
        transaction.setStatus("COMPLETED");
        return repository.save(transaction);
    }
}
