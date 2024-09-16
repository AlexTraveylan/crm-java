package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.model.Lead;
import com.crm.service.LeadService;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    private final LeadService leadService;

    @Autowired
    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Lead> createlead(@RequestBody Lead lead) {
        Lead savedLead = leadService.createLead(lead);
        return new ResponseEntity<>(savedLead, HttpStatus.CREATED);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Lead>> getAllleads() {
        List<Lead> leads = leadService.getAllLeads();
        return new ResponseEntity<>(leads, HttpStatus.OK);
    }

    // Read (single)
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getleadById(@PathVariable Integer id) {
        Lead lead = leadService.getLeadById(id);
        if (lead != null) {
            return new ResponseEntity<>(lead, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updatelead(@PathVariable Integer id, @RequestBody Lead lead) {
        Lead existingLead = leadService.getLeadById(id);
        if (existingLead != null) {
            lead.setId(id);
            Lead updatedLead = leadService.createLead(lead);
            return new ResponseEntity<>(updatedLead, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletelead(@PathVariable Integer id) {
        Lead existingLead = leadService.getLeadById(id);
        if (existingLead != null) {
            leadService.deleteLead(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
