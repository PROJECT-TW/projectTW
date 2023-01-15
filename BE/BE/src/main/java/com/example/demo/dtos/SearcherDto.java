package com.example.demo.dtos;

public class SearcherDto extends UserDto{

    public SearcherDto() {
    }
    public SearcherDto(String email, String lastName, String firstName, String password, String password2, boolean type, String location, String phone, String ocupation) {
        super(email,lastName, firstName,password, password2, type,location,phone,ocupation);
    }

}
