package com.example.demo.repository;

import com.example.demo.entity.Searcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearcherRepository extends JpaRepository<Searcher, Long > {
    Searcher findByEmail(String email);
}