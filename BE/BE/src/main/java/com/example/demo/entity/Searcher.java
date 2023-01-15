package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "searchers")
public class Searcher extends User{

    public Searcher(String email, String lastName, String firstName, String password, boolean type, String location, String phone, String ocupation) {
        super(email, lastName, firstName, password, type, location, phone, ocupation);
    }

    public Searcher() {
        super();

    }


}
