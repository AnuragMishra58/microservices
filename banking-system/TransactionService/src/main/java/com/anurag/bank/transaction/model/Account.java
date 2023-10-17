package com.anurag.bank.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long accountNumber;
    private Long customerId;
    private BigDecimal accountBalance;
    private String accountType;
}
