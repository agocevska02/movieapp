package com.example.movieapplication.repository;

import com.example.movieapplication.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByName(String name);
}
