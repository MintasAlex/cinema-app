package com.training.cinemaapp.services;

import com.training.cinemaapp.models.MovieGenre;
import com.training.cinemaapp.repositories.MovieGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieGenreService {

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    public List<MovieGenre> getMovieGenres() {
        return movieGenreRepository.findAll();
    }

    public List<MovieGenre> getMovieGenresByMovieId(int movieId) {
        return movieGenreRepository.findByMovieId(movieId);
    }

    public List<MovieGenre> getMovieGenresByGenreName(String genreName) {
        return movieGenreRepository.findByGenreName(genreName);
    }

    public Optional<?> getMovieGenreByMovieIdAndGenreName(int movieId, String genreName) {
        return movieGenreRepository.findByMovieIdAndGenreName(movieId, genreName);
    }

    public MovieGenre addMovieGenre(MovieGenre movieGenre) {
        return movieGenreRepository.save(movieGenre);
    }

    public Boolean deleteMovieGenre(int movieId, String genreName) {
        if (movieGenreRepository.existsByMovieIdAndGenreName(movieId, genreName)) {
            movieGenreRepository.deleteByMovieIdAndGenreName(movieId, genreName);
            return true;
        } else {
            return false;
        }
    }


}
