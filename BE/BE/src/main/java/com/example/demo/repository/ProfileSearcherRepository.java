package com.example.demo.repository;

import com.example.demo.entity.ProfileSearcher;
import com.example.demo.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileSearcherRepository extends JpaRepository<ProfileSearcher, Long > {

    ProfileSearcher findByEmail(String email);
}
