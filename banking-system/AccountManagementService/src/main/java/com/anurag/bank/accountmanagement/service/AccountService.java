package com.anurag.bank.accountmanagement.service;

import com.anurag.bank.accountmanagement.entity.Account;
import com.anurag.bank.accountmanagement.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    @Autowired
    AccountRepository repository;

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account creditAccount(Long accountNumber, BigDecimal amount) {
        Account account = repository.findById(accountNumber).orElse(null);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance().add(amount));
            return repository.save(account);
        }
        throw new RuntimeException("Account does not exist");
    }

    public Account debitAccount(Long accountNumber, BigDecimal amount) {
        Account account = repository.findById(accountNumber).orElse(null);
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance().subtract(amount));
            return repository.save(account);
        }
        throw new RuntimeException("Account does not exist");
    }

    public Account getAccount(Long accountNumber) {
        return repository.findById(accountNumber).orElse(null);
    }
}
