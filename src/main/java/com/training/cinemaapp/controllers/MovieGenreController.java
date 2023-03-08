package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.MovieGenre;
import com.training.cinemaapp.services.MovieGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieGenreController {

    @Autowired
    private MovieGenreService movieGenreService;

    @GetMapping("/movie-genres")
    public List<MovieGenre> getMovieGenres() {
        return movieGenreService.getMovieGenres();
    }
}
