package com.example.movieapplication.web;

import com.example.movieapplication.model.Movie;
import com.example.movieapplication.service.impl.MovieServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"/movies", "/"})
public class MovieController {

    private final MovieServiceImpl movieService;

    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(Model model, @PathVariable Long id) {
        movieService.deleteMovie(id);
        model.addAttribute("movies", movieService.getAllMovies());
        return "redirect:/movies";
    }

    @GetMapping("/add_movie")
    public String addMovie(Model model) {
        return "addMovies";
    }

    @PostMapping("/addMovie")
    public String addMovie(
            @RequestParam("title") String title,
            @RequestParam("director") String director,
            @RequestParam("genres") String genres,
            @RequestParam("imdbRating") Float imdbRating,
            @RequestParam("metascore") Integer metascore,
            @RequestParam("poster") String poster,
            Model model) {

        Movie movie = new Movie(title, director, genres, imdbRating, metascore, poster);

        movieService.createMovie(movie.getTitle(),movie.getDirector(),movie.getGenres(),movie.getImdbRating(),movie.getMetascore(),movie.getPoster());

        return "redirect:/movies";
    }
}
