package com.anurag.bank.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TRANSACTIONS")
@Data
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;
    private Long customerId;
    private Long accountNumber;
    private String transactionType;
    private String status;
    private BigDecimal amount;
}
