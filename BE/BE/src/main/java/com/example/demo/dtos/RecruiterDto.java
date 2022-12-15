package com.example.demo.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RecruiterDto extends UserDto{
    private String organization;

    public RecruiterDto() {
        super();
    }

    public RecruiterDto(String email,String lastName, String firstName,String password,  String password2,String type, String organization) {
        super(email,lastName,firstName, password, password2, type);
        this.organization=organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


}
