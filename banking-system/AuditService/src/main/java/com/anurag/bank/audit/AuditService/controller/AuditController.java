package com.anurag.bank.audit.AuditService.controller;

import com.anurag.bank.audit.AuditService.entity.AuditRecord;
import com.anurag.bank.audit.AuditService.repository.AuditRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audits")
public class AuditController {
    @Autowired
    private AuditRecordRepository repository;
    @GetMapping
    public List<AuditRecord> getAuditRecords(){
        return repository.findAll();
    }

}
