package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Movie;
import com.training.cinemaapp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable int id) {
        if(movieService.getMovieById(id).isPresent()) {
            return ResponseEntity.ok().body(movieService.getMovieById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movies")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        Movie newMovie = movieService.addMovie(movie);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newMovie.getId())
                .toUri();
        return ResponseEntity.created(location).body(newMovie);
    }

    @PutMapping("/movies/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateMovie(@Valid @RequestBody Movie newMovie, @PathVariable int id) {
        if (movieService.updateMovie(newMovie, id).isPresent()) {
            return ResponseEntity.ok().body(movieService.updateMovie(newMovie, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/movies/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteMovie(@PathVariable int id) {
        if (movieService.deleteMovie(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
