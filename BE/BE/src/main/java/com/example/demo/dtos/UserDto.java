package com.example.demo.dtos;

public class UserDto {

    private Long id;
    private String email;
    private String lastName;
    private String firstName;
    private String password;


    public UserDto(String email,String lastName, String firstName,String password) {
        this.email = email;
        this.lastName=lastName;
        this.firstName=firstName;
        this.password=password;
    }

    public UserDto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
