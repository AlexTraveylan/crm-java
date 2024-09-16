package com.crm.service;

import com.crm.model.Lead;
import com.crm.repository.LeadRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    private LeadRepository leadRepository;

    @Autowired
    public void LeadServiceImpl(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public Lead getLeadById(Integer id) {
        return leadRepository.findById(id).orElse(null);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public void deleteLead(Integer id) {
        leadRepository.deleteById(id);
    }

    public void updateLead(Lead lead) {
        leadRepository.save(lead);
    }

}