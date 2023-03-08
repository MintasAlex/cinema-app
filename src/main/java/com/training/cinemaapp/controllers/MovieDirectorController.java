package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.MovieDirector;
import com.training.cinemaapp.repositories.MovieDirectorRepository;
import com.training.cinemaapp.services.MovieDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieDirectorController {

    @Autowired
    private MovieDirectorService movieDirectorService;

    @GetMapping("/movie-directors")
    public List<MovieDirector> getMovieDirectors() {
        return movieDirectorService.getMovieDirectors();
    }
}
