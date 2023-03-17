package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Screening;
import com.training.cinemaapp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/screenings")
    public List<Screening> getScreenings() {
        return screeningService.getScreenings();
    }

    @GetMapping("/screenings/{movieId}")
    public List<Screening> getScreeningByMovieId(@PathVariable int movieId) {
        return screeningService.getScreeningByMovieId(movieId);
    }

    @GetMapping("/screenings/cinemaHall/{cinemaHallId}")
    public List<Screening> getScreeningByCinemaHallId(@PathVariable int cinemaHallId) {
        return screeningService.getScreeningByCinemaHallId(cinemaHallId);
    }

    @GetMapping("/screenings/{id}")
    public ResponseEntity<?> getScreeningById(@PathVariable int id) {
        if (screeningService.getScreeningById(id).isPresent()) {
            return ResponseEntity.ok().body(screeningService.getScreeningById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/screenings")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Screening> addScreening(@Valid @RequestBody Screening screening) {
        Screening newScreening = screeningService.addScreening(screening);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newScreening.getId())
                .toUri();
        return ResponseEntity.created(location).body(newScreening);
    }

    @PutMapping("/screenings/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateScreening(@Valid @RequestBody Screening newScreening, @PathVariable int id) {
        if (screeningService.updateScreening(newScreening, id).isPresent()) {
            return ResponseEntity.ok().body(screeningService.updateScreening(newScreening, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/screenings/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteScreening(@PathVariable int id) {
        if (screeningService.deleteScreening(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
