package com.example.demo.repository;

import com.example.demo.entity.Application;
import com.example.demo.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository  extends JpaRepository<Favorite, String> {
}
