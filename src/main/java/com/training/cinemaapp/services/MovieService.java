package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Movie;
import com.training.cinemaapp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
