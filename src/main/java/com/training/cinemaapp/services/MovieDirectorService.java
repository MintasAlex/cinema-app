package com.training.cinemaapp.services;

import com.training.cinemaapp.models.MovieDirector;
import com.training.cinemaapp.repositories.MovieDirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieDirectorService {

    @Autowired
    private MovieDirectorRepository movieDirectorRepository;

    public List<MovieDirector> getMovieDirectors() {
        return movieDirectorRepository.findAll();
    }

    public List<MovieDirector> getMovieDirectorByMovieId(int movieId) {
        return movieDirectorRepository.findByMovieId(movieId);
    }

    public Optional<MovieDirector> getMovieDirectorByMovieIdAndDirectorName(int movieId, String directorName) {
        return movieDirectorRepository.findByMovieIdAndName(movieId, directorName);
    }

    public MovieDirector addMovieDirector(MovieDirector movieDirector) {
        return movieDirectorRepository.save(movieDirector);
    }

    public Boolean deleteMovieDirector(int movieId, String directorName) {
        if (movieDirectorRepository.existsByMovieIdAndName(movieId, directorName)) {
            movieDirectorRepository.deleteByMovieIdAndName(movieId, directorName);
            return true;
        } else {
            return false;
        }
    }

}
