package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.CinemaHall;
import com.training.cinemaapp.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @GetMapping("/cinema-halls")
    public List<CinemaHall> getCinemaHalls() {
        return cinemaHallService.getCinemaHalls();
    }

    @GetMapping("/cinema-halls/{id}")
    public ResponseEntity<?> getCinemaHallById(@PathVariable Integer id) {
        if (cinemaHallService.getCinemaHallById(id).isPresent()) {
            return ResponseEntity.ok().body(cinemaHallService.getCinemaHallById(id));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/cinema-halls")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CinemaHall> addCinemaHall(@Valid @RequestBody CinemaHall cinemaHall) {
        CinemaHall newCinemaHall = cinemaHallService.addCinemaHall(cinemaHall);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCinemaHall.getId())
                .toUri();
        return ResponseEntity.created(location).body(newCinemaHall);
    }

    @PutMapping("/cinema-halls/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateCinemaHall(@Valid @RequestBody CinemaHall newCinemaHall, @PathVariable Integer id) {
        if (cinemaHallService.updateCinemaHall(newCinemaHall, id).isPresent()) {
            return ResponseEntity.ok().body(cinemaHallService.updateCinemaHall(newCinemaHall, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/cinema-halls/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteCinemaHall(@PathVariable Integer id) {
        if (cinemaHallService.deleteCinemaHall(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
