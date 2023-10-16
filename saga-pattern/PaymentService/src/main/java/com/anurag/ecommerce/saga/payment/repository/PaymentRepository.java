package com.anurag.ecommerce.saga.payment.repository;


import com.anurag.ecommerce.saga.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
