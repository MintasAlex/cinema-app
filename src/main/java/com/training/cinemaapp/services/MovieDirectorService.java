package com.training.cinemaapp.services;

import com.training.cinemaapp.models.MovieDirector;
import com.training.cinemaapp.repositories.MovieDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDirectorService {

    @Autowired
    private MovieDirectorRepository movieDirectorRepository;

    public List<MovieDirector> getMovieDirectors() {
        return movieDirectorRepository.findAll();
    }
}
