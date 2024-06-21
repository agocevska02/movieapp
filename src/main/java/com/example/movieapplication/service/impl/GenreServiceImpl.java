package com.example.movieapplication.service.impl;

import com.example.movieapplication.model.Genre;
import com.example.movieapplication.repository.GenreRepository;
import com.example.movieapplication.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre addGenre(String name) {
        return genreRepository.save(new Genre(name));
    }

    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }

    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }
}
