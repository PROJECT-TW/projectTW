package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idFavoriteJob", nullable = false)
    private Long idJob;
    @Column(name = "idUser", nullable = false)
    private Long idUser;


    public Favorite() {}

    public Favorite(Long idJob, Long idUser) {
        this.idJob = idJob;
        this.idUser = idUser;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
