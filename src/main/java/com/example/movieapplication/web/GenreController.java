package com.example.movieapplication.web;

import com.example.movieapplication.model.Genre;
import com.example.movieapplication.service.impl.GenreServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {

    private final GenreServiceImpl genreService;

    public GenreController(GenreServiceImpl genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public String listAllGenres(Model model, @RequestParam(required = false) String genre_name) {

        model.addAttribute("genres", genreService.getAllGenres());
        return "genre";
    }
}
