package com.example.demo.dtos;

public class SearcherDto extends UserDto{

    public SearcherDto() {
    }
    public SearcherDto(String email,String lastName, String firstName,String password, String password2, String type) {
        super(email,lastName, firstName,password, password2, type);
    }

}
