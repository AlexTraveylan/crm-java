package com.crm.model;

import lombok.Data;

@Data
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

}