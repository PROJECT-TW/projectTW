package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "searchers")
public class Searcher extends User{
    public Searcher(String email,String lastName, String firstName, String password, String typeOfAccount) {
        super(email,lastName,firstName, password);

    }

    public Searcher() {
        super();

    }

}
