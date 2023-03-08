package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Movie;
import com.training.cinemaapp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }
}
