package com.example.movieapplication.service;

import com.example.movieapplication.model.Genre;

import java.util.List;

public interface GenreService {

    public List<Genre> getAllGenres();
    public Genre addGenre(String name);
    public Genre findByName(String name);

    public Genre save(Genre genre) ;
}
