package com.example.demo.dtos;

public class SearcherDto extends UserDto{

    public SearcherDto() {
    }
    public SearcherDto(String email,String lastName, String firstName,String password) {
        super(email,lastName, firstName,password);
    }

}
