package repository;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.crm.repository.LeadRepository;
import com.crm.model.Lead;

public class LeadRepositoryTest {

    @Test
    public void testAddLead() {
        LeadRepository repository = new LeadRepository();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        repository.addLead(lead);

        assertEquals(1, repository.getAllLeads().size());
    }

    @Test
    public void testGetAllLeads() {
        LeadRepository repository = new LeadRepository();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        repository.addLead(lead);

        assertEquals(1, repository.getAllLeads().size());
    }

    @Test
    public void testGetLeadById() {
        LeadRepository repository = new LeadRepository();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        repository.addLead(lead);

        Lead result = repository.getLeadById(1);
        assertEquals(lead, result);
    }

    @Test
    public void testUpdateLead() {
        LeadRepository repository = new LeadRepository();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        repository.addLead(lead);

        Lead updatedLead = new Lead();
        updatedLead.setId(1);
        updatedLead.setContactName("Jane Doe");
        updatedLead.setCompany("New Company");
        updatedLead.setEmail("jane.doe@example.com");

        Lead result = repository.updateLead(updatedLead);
        assertEquals(updatedLead.getId(), result.getId());
        assertEquals(updatedLead.getContactName(), result.getContactName());
        assertEquals(updatedLead.getCompany(), result.getCompany());
        assertEquals(updatedLead.getEmail(), result.getEmail());
    }

    @Test
    public void testDeleteLead() {
        LeadRepository repository = new LeadRepository();
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        repository.addLead(lead);

        repository.deleteLead(1);
        assertEquals(0, repository.getAllLeads().size());
    }

}
