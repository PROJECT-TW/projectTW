package com.example.demo.entity;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public  class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", unique=true, nullable = false)
    private String email;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "password", nullable = false)
    private String password;
    public User(String email, String lastName, String firstName, String password) {
        this.email=email;
        this.lastName=lastName;
        this.firstName=firstName;
        this.password=password;
    }

    public User() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
