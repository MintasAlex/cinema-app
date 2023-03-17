package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Cinema;
import com.training.cinemaapp.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas")
    public List<Cinema> getCinemas() {
        return cinemaService.getCinemas();
    }

    @GetMapping("/cinemas/{id}")
    public ResponseEntity<?> getCinemaById(@PathVariable int id) {
        if (cinemaService.getCinemaById(id).isPresent()) {
            return ResponseEntity.ok().body(cinemaService.getCinemaById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cinemas")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Cinema> addCinema(@Valid @RequestBody Cinema cinema) {
        Cinema newCinema = cinemaService.addCinema(cinema);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCinema.getId())
                .toUri();
        return ResponseEntity.created(location).body(newCinema);
    }

    @PutMapping("/cinemas/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateCinema(@Valid @RequestBody Cinema newCinema, @PathVariable int id) {
        if (cinemaService.updateCinema(newCinema, id).isPresent()) {
            return ResponseEntity.ok().body(cinemaService.updateCinema(newCinema, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cinemas/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCinema(@PathVariable int id) {
        if (cinemaService.deleteCinema(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
