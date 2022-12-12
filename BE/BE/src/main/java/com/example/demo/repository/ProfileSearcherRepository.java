package com.example.demo.repository;

import com.example.demo.entity.ProfileSearcher;
import com.example.demo.entity.Searcher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileSearcherRepository {
    List<ProfileSearcher> findAll();

    ProfileSearcher findByEmail(String email);

    ProfileSearcher save(ProfileSearcher profileSearcherEntity);
}
