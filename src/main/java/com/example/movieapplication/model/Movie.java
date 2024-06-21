package com.example.movieapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Setter
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private String genres;
    private Float imdbRating;
    private Integer metascore;
    private String poster;

    public Movie() {

    }

    public Movie(String title, String director, String genres, float rating, int duration, String imageurl) {
        this.title = title;
        this.director = director;
        this.genres = genres;
        this.imdbRating = rating;
        this.metascore = duration;
        this.poster = imageurl;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", imdbRating=" + imdbRating +
                ", metascore=" + metascore +
                ", poster='" + poster + '\'' +
                '}';
    }
}
