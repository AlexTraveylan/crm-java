package service;

import com.crm.service.LeadService;
import com.crm.model.Lead;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeadServiceTest {

    @Test
    public void testAddLead() {
        LeadService service = new LeadService();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        service.addLead(lead);

        assertEquals(1, service.getAllLeads().size());
    }

    @Test
    public void testGetAllLeads() {
        LeadService service = new LeadService();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        service.addLead(lead);

        assertEquals(1, service.getAllLeads().size());
    }

    @Test
    public void testGetLeadById() {
        LeadService service = new LeadService();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        service.addLead(lead);

        Lead result = service.getLeadById(1);
        assertEquals(lead, result);
    }

    @Test
    public void testUpdateLead() {
        LeadService service = new LeadService();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        service.addLead(lead);

        Lead updatedLead = new Lead();
        updatedLead.setId(1);
        updatedLead.setContactName("Jane Doe");
        updatedLead.setCompany("New Company");
        updatedLead.setEmail("jane.doe@example.com");

        Lead result = service.updateLead(updatedLead);
        assertEquals(updatedLead.getId(), result.getId());
        assertEquals(updatedLead.getContactName(), result.getContactName());
        assertEquals(updatedLead.getCompany(), result.getCompany());
        assertEquals(updatedLead.getEmail(), result.getEmail());
    }

    @Test
    public void testDeleteLead() {
        LeadService service = new LeadService();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        service.addLead(lead);

        service.deleteLead(1);
        assertEquals(0, service.getAllLeads().size());
    }
}
