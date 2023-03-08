package com.training.cinemaapp.services;

import com.training.cinemaapp.models.MovieGenre;
import com.training.cinemaapp.repositories.MovieGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieGenreService {

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    public List<MovieGenre> getMovieGenres() {
        return movieGenreRepository.findAll();
    }
}
