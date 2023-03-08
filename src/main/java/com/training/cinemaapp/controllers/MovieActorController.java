package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.MovieActor;
import com.training.cinemaapp.services.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieActorController {

    @Autowired
    private MovieActorService movieActorService;

    @GetMapping("/movie-actors")
    public List<MovieActor> getMovieActors() {
        return movieActorService.getMovieActors();
    }
}
