package model;

import com.crm.model.Lead;
import static org.junit.Assert.*;
import org.junit.Test;

public class LeadTest {

    @Test
    public void testGettersAndSetters() {
        Lead lead = new Lead();
        lead.setId(1);
        assertEquals(1, lead.getId());

        lead.setContactName("John Doe");
        assertEquals("John Doe", lead.getContactName());

        lead.setCompany("ACME Inc.");
        assertEquals("ACME Inc.", lead.getCompany());

        lead.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", lead.getEmail());
    }

    @Test
    public void testToString() {
        Lead lead = new Lead();
        lead.setId(1);
        lead.setContactName("John Doe");
        lead.setCompany("ACME Inc.");
        lead.setEmail("john.doe@example.com");

        String expected = "Lead{id=1, contactName='John Doe', company='ACME Inc.', email='john.doe@example.com'}";
        assertEquals(expected, lead.toString());
    }
}
