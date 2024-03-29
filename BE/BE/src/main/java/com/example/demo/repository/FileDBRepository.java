package com.example.demo.repository;

import com.example.demo.entity.FileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDb, String> {

}
