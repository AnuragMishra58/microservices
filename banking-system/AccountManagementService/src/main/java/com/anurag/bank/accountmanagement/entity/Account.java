package com.anurag.bank.accountmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNTS")
@Data
public class Account {
    @Id
    @GeneratedValue
    private Long accountNumber;
    private Long customerId;
    private BigDecimal accountBalance;
    private String accountType;
}
