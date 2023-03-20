package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Seat;
import com.training.cinemaapp.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats")
    public List<Seat> getSeats() {
        return seatService.getSeats();
    }

    @GetMapping("/seats/cinemaHall/{cinemaHallId}")
    public List<Seat> getSeatsByCinemaHallId(@PathVariable int cinemaHallId) {
        return seatService.getSeatsByCinemaHallId(cinemaHallId);
    }

    @GetMapping("/seats/{id}")
    public ResponseEntity<?> getSeatById(@PathVariable int id) {
        if (seatService.getSeatById(id).isPresent()) {
            return ResponseEntity.ok().body(seatService.getSeatById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/seats")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Seat> addSeat(@Valid @RequestBody Seat seat) {
        Seat newSeat = seatService.addSeat(seat);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newSeat.getId())
                .toUri();
        return ResponseEntity.created(location).body(newSeat);
    }

    @PutMapping("/seats/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateSeat(@Valid @RequestBody Seat newSeat, @PathVariable int id) {
        if (seatService.updateSeat(newSeat, id).isPresent()) {
            return ResponseEntity.ok().body(seatService.updateSeat(newSeat, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/seats/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteSeat(@PathVariable int id) {
        if (seatService.deleteSeat(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
