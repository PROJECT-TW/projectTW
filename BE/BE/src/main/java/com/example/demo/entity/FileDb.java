package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name ="files")
public class FileDb {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idUser", nullable = false)
    private Long idUser;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "type",nullable = false)
    private String type;

    @Lob
    @Column(name = "data",nullable = true)
    private byte[] data;

    public FileDb() {

    }

    public FileDb(Long idUser,String name, String type, byte[] data) {
        super();
        this.idUser=idUser;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}