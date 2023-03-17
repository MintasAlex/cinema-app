package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Movie;
import com.training.cinemaapp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(int id) {
        return movieRepository.findById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(Movie newMovie, int id) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(newMovie.getTitle());
                    movie.setRuntimeMinutes(newMovie.getRuntimeMinutes());
                    movie.setScore(newMovie.getScore());
                    movie.setRating(newMovie.getRating());
                    movie.setDescription(newMovie.getDescription());
                    movie.setPicturePath(newMovie.getPicturePath());
                    movieRepository.save(movie);
                    return movie;
                });
    }

    public Boolean deleteMovie(int id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
