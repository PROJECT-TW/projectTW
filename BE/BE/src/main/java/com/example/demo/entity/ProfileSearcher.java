package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profileSearcher")
public class ProfileSearcher {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", unique=true, nullable = false)
    private String email;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "birthday",nullable = false)
    private Date birthdayDate;
    public ProfileSearcher() {
    }

    public ProfileSearcher(String email, String lastName, String firstName, Date birthdayDate) {
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
