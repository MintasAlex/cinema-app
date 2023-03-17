package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.MovieDirector;
import com.training.cinemaapp.repositories.MovieDirectorRepository;
import com.training.cinemaapp.services.MovieDirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
public class MovieDirectorController {

    @Autowired
    private MovieDirectorService movieDirectorService;

    @GetMapping("/movie-directors")
    public List<MovieDirector> getMovieDirectors() {
        return movieDirectorService.getMovieDirectors();
    }

    @GetMapping("/movie-directors/{movieId}")
    public List<MovieDirector> getMovieDirectorByMovieId(@PathVariable int movieId) {
        return movieDirectorService.getMovieDirectorByMovieId(movieId);
    }

    @GetMapping("/movie-directors/{movieId}/{directorName}")
    public ResponseEntity<?> getMovieDirectorByMovieIdAndDirectorName(@PathVariable int movieId, @PathVariable String directorName) {
        if (movieDirectorService.getMovieDirectorByMovieIdAndDirectorName(movieId, directorName).isPresent()) {
            return ResponseEntity.ok().body(movieDirectorService.getMovieDirectorByMovieIdAndDirectorName(movieId, directorName));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/movie-directors")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieDirector> addMovieDirector(@RequestBody MovieDirector movieDirector) {
        MovieDirector newMovieDirector = movieDirectorService.addMovieDirector(movieDirector);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{movieId}/{directorName}")
                .buildAndExpand(newMovieDirector.getMovieId(), newMovieDirector.getName())
                .toUri();
        return ResponseEntity.created(location).body(newMovieDirector);
    }

    @DeleteMapping("/movie-directors/{movieId}/{directorName}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<?> deleteMovieDirector(@PathVariable int movieId, @PathVariable String directorName) {
        if (movieDirectorService.deleteMovieDirector(movieId, directorName)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
