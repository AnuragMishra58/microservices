package com.anurag.bank.accountmanagement.controller;

import com.anurag.bank.accountmanagement.entity.Account;
import com.anurag.bank.accountmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService service;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> createAccount(@PathVariable("accountNumber") Long accountNumber) {
        return ResponseEntity.ok(service.getAccount(accountNumber));
    }
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(service.createAccount(account));
    }

    @PostMapping("/{accountNumber}/debit")
    public ResponseEntity<Account> debitAccount(@PathVariable("accountNumber") Long accountNumber, @RequestBody BigDecimal amount) {
        return ResponseEntity.ok(service.debitAccount(accountNumber, amount));
    }

    @PostMapping("/{accountNumber}/credit")
    public ResponseEntity<Account> creditAccount(@PathVariable("accountNumber") Long accountNumber, @RequestBody BigDecimal amount) {
        return ResponseEntity.ok(service.creditAccount(accountNumber, amount));
    }
}
