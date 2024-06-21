//package com.example.movieapplication.model.JSON;
//
//import com.example.movieapplication.model.Genre;
//import com.example.movieapplication.model.Movie;
//import com.example.movieapplication.service.impl.GenreServiceImpl;
//import com.example.movieapplication.service.impl.MovieServiceImpl;
//import jakarta.annotation.PostConstruct;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class FetchData {
//
//    private final MovieServiceImpl movieService;
//    private final GenreServiceImpl genreService;
//
//    public FetchData(MovieServiceImpl movieService, GenreServiceImpl genreService) {
//        this.movieService = movieService;
//        this.genreService = genreService;
//    }
//
//    @PostConstruct
//    public void fetchAndSaveMovies() {
//        String apiKey = "345263b4";
//        List<String> movieIds = List.of("tt0111161", "tt0068646");
//
//        for (String movieId : movieIds) {
//            String url = "https://www.omdbapi.com/?i=" + movieId + "&apikey=" + apiKey;
//
//            RestTemplate restTemplate = new RestTemplate();
//            String response = restTemplate.getForObject(url, String.class);
//
//            try {
//                JSONParser parser = new JSONParser();
//                JSONObject dataObj = (JSONObject) parser.parse(response);
//
//                Movie movie = new Movie();
//                movie.setTitle((String) dataObj.get("Title"));
//                movie.setDirector((String) dataObj.get("Director"));
//                List<Genre> genres = new ArrayList<>();
//                String genresString = (String) dataObj.get("Genre");
//                String[] names = genresString.split(",");
//
//                for (String name : names) {
//                    name = name.trim();
//                    Genre genre = genreService.findByName(name);
//                    if (genre == null) {
//                        genre = new Genre();
//                        genre.setName(name);
//                        genreService.save(genre); // Save genre before associating
//                    }
//                    genres.add(genre);
//                }
//                System.out.println(genres);
//                movie.setImdbRating(Float.parseFloat((String) dataObj.get("imdbRating")));
//                movie.setMetascore(Integer.parseInt((String) dataObj.get("Metascore")));
//                movie.setPoster((String) dataObj.get("Poster"));
//                movie.setGenres(genres);
//                System.out.println(movie);
//
//                movieService.createMovie(movie.getTitle(), movie.getDirector(), movie.getGenres(), movie.getImdbRating(), 1, movie.getPoster());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}