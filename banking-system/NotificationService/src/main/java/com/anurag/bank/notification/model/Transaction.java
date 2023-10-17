package com.anurag.bank.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long transactionId;
    private Long customerId;
    private Long accountNumber;
    private String transactionType;
    private String status;
    private BigDecimal amount;
}
