package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.MovieActor;
import com.training.cinemaapp.services.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movie-actors")
public class MovieActorController {

    @Autowired
    private MovieActorService movieActorService;

    @GetMapping("")
    public List<MovieActor> getMovieActors() {
        return movieActorService.getMovieActors();
    }

    @GetMapping("/{movieId}")
    public List<MovieActor> getMovieActorsByMovieId(@PathVariable int movieId) {
        return movieActorService.getMovieActorsByMovieId(movieId);
    }

    @GetMapping("/{movieId}/{actorName}")
    public ResponseEntity<?> getMovieActorByMovieIdAndActorName(@PathVariable int movieId, @PathVariable String actorName) {
        if (movieActorService.getMovieActorByMovieIdAndActorName(movieId, actorName).isPresent()) {
            return ResponseEntity.ok().body(movieActorService.getMovieActorByMovieIdAndActorName(movieId, actorName));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieActor> addMovieActor(@RequestBody MovieActor movieActor) {
        MovieActor newMovieActor = movieActorService.addMovieActor(movieActor);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{movieId}/{actorName}")
                .buildAndExpand(newMovieActor.getMovieId(), newMovieActor.getName())
                .toUri();
        return ResponseEntity.created(location).body(newMovieActor);
    }


    @DeleteMapping("/{movieId}/{actorName}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<?> deleteMovieActor(@PathVariable int movieId, @PathVariable String actorName) {
        if (movieActorService.deleteMovieActor(movieId, actorName)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
