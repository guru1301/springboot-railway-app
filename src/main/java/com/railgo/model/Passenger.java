package com.railgo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String idType;
    private String idNumber;
    private String phone;
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getIdType() {
        return idType;
    }
    
    public void setIdType(String idType) {
        this.idType = idType;
    }
    
    public String getIdNumber() {
        return idNumber;
    }
    
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}