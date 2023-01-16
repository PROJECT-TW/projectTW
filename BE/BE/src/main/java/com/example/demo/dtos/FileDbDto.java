package com.example.demo.dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

public class FileDbDto {
    private Long id;
    private Long idUser;

    private String name;

    private String type;

    private byte[] data;

    public FileDbDto() {

    }

    public FileDbDto(Long idUser,String name, String type, byte[] data) {
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