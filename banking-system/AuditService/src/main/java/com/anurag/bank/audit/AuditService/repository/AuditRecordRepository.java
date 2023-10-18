package com.anurag.bank.audit.AuditService.repository;

import com.anurag.bank.audit.AuditService.entity.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long> {
}
