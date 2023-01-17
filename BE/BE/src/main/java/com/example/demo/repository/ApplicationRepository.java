package com.example.demo.repository;

import com.example.demo.entity.Application;
import com.example.demo.entity.FileDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository  extends JpaRepository<Application, String> {
}
