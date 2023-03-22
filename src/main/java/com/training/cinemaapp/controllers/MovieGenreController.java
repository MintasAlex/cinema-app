package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.MovieGenre;
import com.training.cinemaapp.services.MovieGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movie-genres")
public class MovieGenreController {

    @Autowired
    private MovieGenreService movieGenreService;

    @GetMapping("")
    public List<MovieGenre> getMovieGenres() {
        return movieGenreService.getMovieGenres();
    }

    @GetMapping("/movie/{movieId}")
    public List<MovieGenre> getMovieGenresByMovieId(@PathVariable int movieId) {
        return movieGenreService.getMovieGenresByMovieId(movieId);
    }

    @GetMapping("/genre/{genreName}")
    public List<MovieGenre> getMovieGenresByGenreName(@PathVariable String genreName) {
        return movieGenreService.getMovieGenresByGenreName(genreName);
    }

    @GetMapping("/{movieId}/{genreName}")
    public ResponseEntity<?> getMovieGenreByMovieIdAndGenreName(@PathVariable int movieId, @PathVariable String genreName) {
        if (movieGenreService.getMovieGenreByMovieIdAndGenreName(movieId, genreName).isPresent()) {
            return ResponseEntity.ok().body(movieGenreService.getMovieGenreByMovieIdAndGenreName(movieId, genreName));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MovieGenre> addMovieGenre(@Valid @RequestBody MovieGenre movieGenre) {
        MovieGenre newMovieGenre = movieGenreService.addMovieGenre(movieGenre);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{movieId}/{genreName}")
                .buildAndExpand(newMovieGenre.getMovieId(), newMovieGenre.getGenreName())
                .toUri();
        return ResponseEntity.created(location).body(newMovieGenre);
    }

    @DeleteMapping("/{movieId}/{genreName}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<?> deleteMovieGenre(@PathVariable int movieId, @PathVariable String genreName) {
        if (movieGenreService.deleteMovieGenre(movieId, genreName)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
