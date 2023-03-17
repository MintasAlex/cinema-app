package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.MovieGenre;
import com.training.cinemaapp.models.MovieGenreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, MovieGenreId> {
    List<MovieGenre> findByMovieId(int movieId);

    List<MovieGenre> findByGenreName(String genreName);

    Boolean existsByMovieIdAndGenreName(int movieId, String genreName);

    Optional<MovieGenre> findByMovieIdAndGenreName(int movieId, String genreName);

    void deleteByMovieIdAndGenreName(int movieId, String genreName);
}
