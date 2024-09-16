package controller;

import com.crm.controller.LeadController;
import com.crm.model.Lead;
import com.crm.service.LeadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LeadControllerTest {

    @Mock
    private LeadService leadService;

    @InjectMocks
    private LeadController leadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLead() {
        Lead lead = new Lead();
        lead.setContactName("Test Lead");
        when(leadService.createLead(any(Lead.class))).thenReturn(lead);

        ResponseEntity<Lead> response = leadController.createlead(lead);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(lead, response.getBody());
    }

    @Test
    void testGetAllLeads() {
        List<Lead> leads = Arrays.asList(new Lead(), new Lead());
        when(leadService.getAllLeads()).thenReturn(leads);

        ResponseEntity<List<Lead>> response = leadController.getAllleads();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(leads, response.getBody());
    }

    @Test
    void testGetLeadById_ExistingLead() {
        Lead lead = new Lead();
        lead.setId(1);
        when(leadService.getLeadById(1)).thenReturn(lead);

        ResponseEntity<Lead> response = leadController.getleadById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(lead, response.getBody());
    }

    @Test
    void testGetLeadById_NonExistingLead() {
        when(leadService.getLeadById(1)).thenReturn(null);

        ResponseEntity<Lead> response = leadController.getleadById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testUpdateLead_ExistingLead() {
        Lead existingLead = new Lead();
        existingLead.setId(1);
        Lead updatedLead = new Lead();
        updatedLead.setId(1);
        updatedLead.setContactName("Updated Lead");

        when(leadService.getLeadById(1)).thenReturn(existingLead);
        when(leadService.createLead(any(Lead.class))).thenReturn(updatedLead);

        ResponseEntity<Lead> response = leadController.updatelead(1, updatedLead);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedLead, response.getBody());
    }

    @Test
    void testUpdateLead_NonExistingLead() {
        when(leadService.getLeadById(1)).thenReturn(null);

        ResponseEntity<Lead> response = leadController.updatelead(1, new Lead());

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testDeleteLead_ExistingLead() {
        Lead existingLead = new Lead();
        existingLead.setId(1);
        when(leadService.getLeadById(1)).thenReturn(existingLead);

        ResponseEntity<Void> response = leadController.deletelead(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(leadService, times(1)).deleteLead(1);
    }

    @Test
    void testDeleteLead_NonExistingLead() {
        when(leadService.getLeadById(1)).thenReturn(null);

        ResponseEntity<Void> response = leadController.deletelead(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(leadService, never()).deleteLead(anyInt());
    }
}