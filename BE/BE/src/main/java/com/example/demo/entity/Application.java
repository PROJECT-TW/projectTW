package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idJob", nullable = false)
    private Long idJob;
    @Column(name = "idUser", nullable = false)
    private Long idUser;

    @Column(name = "applicationDate", nullable = true)
    private LocalDate applicationDate;

    public Application() {}

    public Application(Long idJob, Long idUser, LocalDate applicationDate) {
        this.idJob = idJob;
        this.idUser = idUser;
        this.applicationDate = applicationDate;
    }

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

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
}
