package com.example.demo.dtos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JobDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime postDate;

    public JobDto(String title, String description) {
        this.title = title;
        this.description = description;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        this.postDate = now;
    }
    public JobDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }
}