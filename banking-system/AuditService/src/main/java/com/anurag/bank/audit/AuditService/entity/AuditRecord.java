package com.anurag.bank.audit.AuditService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "AuditRecords")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecord {
    @Id
    @GeneratedValue
    private Long auditId;
    private String eventType;
    private String eventData;
    private Date auditDate;
}
