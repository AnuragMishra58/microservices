package com.anurag.ecommerce.saga.notification.messaging;

import com.anurag.ecommerce.saga.notification.model.PaymentNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentConfirmedListener {
    @Autowired
    JavaMailSender javaMailSender;

    @KafkaListener(topics = "PaymentSuccessEvent", groupId = "myGroup", containerFactory = "paymentNotificationKafkaListenerContainerFactory")
    public void sendEmail(PaymentNotification paymentNotification) {
        log.info("Received Message in group myGroup: " + paymentNotification);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@amorders.com");
        message.setTo(paymentNotification.getEmail());
        message.setSubject("Order Confirmed");
        message.setText(String.format("Dear %s Your booking for order %s is confirmed from %s to %s",
                paymentNotification.getOrderId(),
                paymentNotification.getCustomerName(), paymentNotification.getStartDate(), paymentNotification.getEndDate()));
        javaMailSender.send(message);
    }
}
