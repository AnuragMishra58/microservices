package com.anurag.ecommerce.saga.inventory.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentNotification {
    private String orderId;
    private String email;
    private String startDate;
    private String endDate;
    private String customerName;
}
