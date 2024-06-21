package com.example.movieapplication.service.impl;

import com.example.movieapplication.model.Genre;
import com.example.movieapplication.model.Movie;
import com.example.movieapplication.repository.MovieRepository;
import com.example.movieapplication.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createMovie(String name, String author, String genres, float rating, int duration, String imageurl) {
        return movieRepository.save(new Movie(name, author,genres, rating, duration,imageurl));
    }

    @Override
    public Movie editMovie(Long id, String name, String author, String genreId, float rating, int duration,String imageUrl) {
        Movie m = findById(id);
       m.setDirector(author);
       m.setTitle(name);
       m.setImdbRating(rating);
       m.setPoster(imageUrl);
       m.setMetascore(duration);
        return movieRepository.save(m);
    }

    @Override
    public Movie deleteMovie(Long id) {
        Movie m = findById(id);
        movieRepository.delete(m);
        return m;
    }
}
