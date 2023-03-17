package com.training.cinemaapp.services;

import com.training.cinemaapp.models.MovieActor;
import com.training.cinemaapp.repositories.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieActorService {

    @Autowired
    private MovieActorRepository movieActorRepository;

    public List<MovieActor> getMovieActors() {
        return movieActorRepository.findAll();
    }

    public List<MovieActor> getMovieActorsByMovieId(int movieId) {
        return movieActorRepository.findByMovieId(movieId);
    }

    public Optional<MovieActor> getMovieActorByMovieIdAndActorName(int movieId, String actorName) {
        return movieActorRepository.findByMovieIdAndName(movieId, actorName);
    }

    public MovieActor addMovieActor(MovieActor movieActor) {
        return movieActorRepository.save(movieActor);
    }

    public Boolean deleteMovieActor(int movieId, String actorName) {
        if (movieActorRepository.existsByMovieIdAndName(movieId, actorName)) {
            movieActorRepository.deleteByMovieIdAndName(movieId, actorName);
            return true;
        } else {
            return false;
        }
    }
}
