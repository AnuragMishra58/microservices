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
public class PaymentRefundedListener {
    @Autowired
    JavaMailSender javaMailSender;

    @KafkaListener(topics = "PaymentFailedEvent", groupId = "myGroup", containerFactory = "paymentCancellationKafkaListenerContainerFactory")
    public void sendEmail(PaymentNotification paymentNotification) {
        log.info("Received Message in group myGroup: " + paymentNotification);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@amorders.com");
        message.setTo(paymentNotification.getEmail());
        message.setSubject("Order Cancelled");
        message.setText(String.format("Dear %s Your Order %s from %s to %s is cancelled",
                paymentNotification.getOrderId(),
                paymentNotification.getCustomerName(), paymentNotification.getStartDate(), paymentNotification.getEndDate()));
        javaMailSender.send(message);
    }
}
