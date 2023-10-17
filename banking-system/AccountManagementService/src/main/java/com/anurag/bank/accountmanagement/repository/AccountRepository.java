package com.anurag.bank.accountmanagement.repository;


import com.anurag.bank.accountmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
