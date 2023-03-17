package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.MovieDirector;
import com.training.cinemaapp.models.MovieDirectorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDirectorRepository extends JpaRepository<MovieDirector, MovieDirectorId> {
    List<MovieDirector> findByMovieId(int movieId);

    Boolean existsByMovieIdAndName(int movieId, String name);
    Optional<MovieDirector> findByMovieIdAndName(int movieId, String name);
    void deleteByMovieIdAndName(int movieId, String name);
}
