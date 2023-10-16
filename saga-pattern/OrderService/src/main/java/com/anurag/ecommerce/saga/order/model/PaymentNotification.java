package com.anurag.ecommerce.saga.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentNotification {
    private String orderId;
    private String email;
    private String startDate;
    private String endDate;
    private String customerName;
}
