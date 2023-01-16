package com.example.demo.entity;


import org.springframework.core.io.Resource;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;

@Entity
@Table(name ="files")
public class FileDb extends InputStream {

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

    @Override
    public int read() throws IOException {
        return 0;
    }

    public FileDb(Long idUser,String name, String type, byte[] data) {
        super();
        this.idUser=idUser;
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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