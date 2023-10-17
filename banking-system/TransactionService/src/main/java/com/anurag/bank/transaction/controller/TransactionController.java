package com.anurag.bank.transaction.controller;

import com.anurag.bank.transaction.entity.Transaction;
import com.anurag.bank.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionService service;
    @PostMapping("/initiateTransaction")
    public ResponseEntity<Transaction> createAccount(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(service.createTransaction(transaction));
    }

    @PostMapping("{transactionId}/completeTransaction")
    public ResponseEntity<Transaction> createAccount(@PathVariable("transactionId") Long transactionId) {
        return ResponseEntity.ok(service.completeTransaction(transactionId));
    }
}
