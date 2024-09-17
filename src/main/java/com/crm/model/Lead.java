package com.crm.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;
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
    @NotBlank
    @Size(max = 100)
    private String contactName;

    @Column(name = "company")
    @NotBlank
    @Size(max = 100)
    private String company;

    @Column(name = "email")
    @Email
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
