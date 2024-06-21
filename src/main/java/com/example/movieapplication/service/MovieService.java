package com.example.movieapplication.service;

import com.example.movieapplication.model.Genre;
import com.example.movieapplication.model.Movie;

import java.util.List;

public interface MovieService {

    public Movie findById(Long id);
    public List<Movie> getAllMovies();
    public Movie createMovie(String name, String author, String genres,float rating, int duration, String imageurl);
    public Movie editMovie(Long id,String name, String author,String genreId, float rating,int duration,String imageUrl);
    public Movie deleteMovie(Long id);
}
