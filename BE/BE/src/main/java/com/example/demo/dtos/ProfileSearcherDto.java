package com.example.demo.dtos;

import javax.persistence.Column;
import java.util.Date;

public class ProfileSearcherDto extends UserDto{
    private Long id;

    private String email;
    private String lastName;
    private String firstName;
    private Date birthdayDate;
    public ProfileSearcherDto() {

    }

    public ProfileSearcherDto(String email, String lastName, String firstName, Date birthdayDate) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthdayDate = birthdayDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
