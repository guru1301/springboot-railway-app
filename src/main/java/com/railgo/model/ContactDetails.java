package com.railgo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ContactDetails {
    private String email;
    private String phone;
    private String alternativePhone;
    
    // Getters and setters
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAlternativePhone() {
        return alternativePhone;
    }
    
    public void setAlternativePhone(String alternativePhone) {
        this.alternativePhone = alternativePhone;
    }
}