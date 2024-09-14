package com.crm.repository;

import com.crm.model.Lead;
import java.util.ArrayList;
import java.util.List;

public class LeadRepository {
    private List<Lead> leads = new ArrayList<>();

    public void addLead(Lead lead) {
        leads.add(lead);
    }

    public List<Lead> getAllLeads() {
        return leads;
    }

    public Lead getLeadById(int id) {
        for (Lead lead : leads) {
            if (lead.getId() == id) {
                return lead;
            }
        }
        return null;
    }

    public Lead updateLead(Lead lead) {
        for (Lead l : leads) {
            if (l.getId() == lead.getId()) {
                l.setContactName(lead.getContactName());
                l.setCompany(lead.getCompany());
                l.setEmail(lead.getEmail());
                return l;
            }
        }
        return null;
    }

    public void deleteLead(int id) {
        for (Lead l : leads) {
            if (l.getId() == id) {
                leads.remove(l);
                return;
            }
        }
    }
}