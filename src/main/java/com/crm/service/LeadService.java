package com.crm.service;

import com.crm.model.Lead;
import com.crm.repository.LeadRepository;

import java.util.List;

public class LeadService {
    private LeadRepository repository = new LeadRepository();

    public void addLead(Lead lead) {
        repository.addLead(lead);
    }

    public List<Lead> getAllLeads() {
        return repository.getAllLeads();
    }

    public Lead getLeadById(int id) {
        return repository.getLeadById(id);
    }

    public Lead updateLead(Lead lead) {
        return repository.updateLead(lead);
    }

    public void deleteLead(int id) {
        repository.deleteLead(id);
    }
}