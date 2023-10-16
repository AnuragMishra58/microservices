package com.anurag.ecommerce.saga.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentNotification {
    private String orderId;
    private String email;
    private String startDate;
    private String endDate;
    private String customerName;
}
