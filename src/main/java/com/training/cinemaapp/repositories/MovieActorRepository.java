package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.MovieActor;
import com.training.cinemaapp.models.MovieActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, MovieActorId> {
    List<MovieActor> findByMovieId(int movieId);
    Boolean existsByMovieIdAndName(int movieId, String name);
    Optional<MovieActor> findByMovieIdAndName(int movieId, String name);
    void deleteByMovieIdAndName(int movieId, String name);
}
