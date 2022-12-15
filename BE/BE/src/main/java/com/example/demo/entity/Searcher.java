package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "searchers")
public class Searcher extends User{
    public Searcher(String email,String lastName, String firstName, String password, String type) {
        super(email,lastName,firstName, password,type);

    }

    public Searcher() {
        super();

    }


}
