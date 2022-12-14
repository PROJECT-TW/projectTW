package com.example.demo.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RecruiterDto extends UserDto{
    private String password2;

    private String organization;

    public RecruiterDto() {
        super();
    }

    public RecruiterDto(String email,String lastName, String firstName,String password,String password2, String organization) {
        super(email,lastName,firstName, password);
        this.password2=password2;
        this.organization=organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
