package com.example.demo.dtos;

public class SignUpFormDto extends UserDto{
    private String organization;

    public SignUpFormDto(String email,String lastName, String firstName,String password, String password2,boolean type, String organization,String location, String ocupation, String phone) {
        super(email,lastName, firstName,password, password2, type,location,phone,ocupation);
        this.organization=organization;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }


}
