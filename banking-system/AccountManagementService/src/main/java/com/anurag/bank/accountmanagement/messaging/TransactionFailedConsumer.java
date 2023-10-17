package com.anurag.bank.accountmanagement.messaging;


import com.anurag.bank.accountmanagement.entity.Account;
import com.anurag.bank.accountmanagement.model.Transaction;
import com.anurag.bank.accountmanagement.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TransactionFailedConsumer {
    @Autowired
    AccountRepository repository;

    @KafkaListener(topics = "TransactionFailedEvent", groupId = "myGroup")
    public void updateInventory(Transaction transaction) {
        Account account = repository.findById(Long.valueOf(transaction.getAccountNumber())).orElse(null);
        if (account != null) {
            if("CREDIT".equalsIgnoreCase(transaction.getTransactionType())){
                account.setAccountBalance(account.getAccountBalance().subtract(transaction.getAmount()));
            }else{
                account.setAccountBalance(account.getAccountBalance().add(transaction.getAmount()));
            }
            repository.save(account);
            log.info("Account amount reverted");
        }
        System.out.println("Received Message in group foo: " + transaction);
    }
}
