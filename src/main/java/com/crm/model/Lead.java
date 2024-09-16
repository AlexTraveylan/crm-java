package com.crm.model;

import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "company")
    private String company;

    @Column(name = "email")
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
