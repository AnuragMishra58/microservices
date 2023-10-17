package com.anurag.bank.notification.messaging;


import com.anurag.bank.notification.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SuspiciousActivityEventConsumer {
    @Autowired
    JavaMailSender javaMailSender;

    @KafkaListener(topics = "SuspiciousActivityEvent", groupId = "myGroup", containerFactory = "suspiciousActivityKafkaListenerContainerFactory")
    public void sendEmail(Transaction transaction) {
        log.info("Received Message in group myGroup: " + transaction);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@frauddetection.com");
        message.setTo("dummycustomer@test.com");
        message.setSubject("Suspicious Order");
        message.setText(String.format("Customer %s, transaction %s is suspicious", transaction.getCustomerId(),
                transaction.getTransactionId()));
        javaMailSender.send(message);
    }
}
