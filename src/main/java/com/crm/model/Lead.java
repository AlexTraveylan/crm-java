package com.crm.model;

public class Lead {
    private int id;
    private String contactName;
    private String company;
    private String email;

    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", contactName='" + contactName + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}