package com.anurag.bank.transaction.feignclient;

import com.anurag.bank.transaction.model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@FeignClient(name = "accountmanagement", url = "http://localhost:8080", path="/accounts")
public interface AccountClient {
    @PostMapping("/{accountNumber}/credit")
    Account creditAccount(@PathVariable("accountNumber") Long accountNumber, @RequestBody BigDecimal amount);
    @PostMapping("/{accountNumber}/debit")
    Account debitAccount(@PathVariable("accountNumber") Long accountNumber, @RequestBody BigDecimal amount);
}
