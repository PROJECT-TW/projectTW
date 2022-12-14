package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="recruiters")
public class Recruiter extends User{
    @Column(name = "organization", nullable = false)
    private String organization;
    public Recruiter(String email,String lastName, String firstName, String password,  String organization) {
        super(email,lastName,firstName,password);
        this.organization=organization;
    }

    public Recruiter() {
        super();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
