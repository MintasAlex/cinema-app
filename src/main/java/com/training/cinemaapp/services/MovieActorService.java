package com.training.cinemaapp.services;

import com.training.cinemaapp.models.MovieActor;
import com.training.cinemaapp.repositories.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieActorService {

    @Autowired
    private MovieActorRepository movieActorRepository;

    public List<MovieActor> getMovieActors() {
        return movieActorRepository.findAll();
    }
}
