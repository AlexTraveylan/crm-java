
package com.crm.model;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private String email;
    private String phone;

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}