package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.SeatBooked;
import com.training.cinemaapp.services.SeatBookedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class SeatBookedController {

    @Autowired
    private SeatBookedService seatBookedService;

    @GetMapping("/seatBooked")
    public List<SeatBooked> getSeatsBooked() {
        return seatBookedService.getSeatsBooked();
    }

    @GetMapping("/seatBooked/{bookingId}")
    public List<SeatBooked> getSeatsBookedByBookingId(@PathVariable int bookingId) {
        return seatBookedService.getSeatsBookedByBookingId(bookingId);
    }

    @GetMapping("/seatBooked/seat/{seatId}")
    public List<SeatBooked> getSeatsBookedBySeatId(@PathVariable int seatId) {
        return seatBookedService.getSeatsBookedBySeatId(seatId);
    }

    @GetMapping("/seatBooked/{bookingId}/{seatId}")
    public ResponseEntity<?> getSeatBookedByBookingIdAndSeatId(@PathVariable int bookingId, @PathVariable int seatId) {
        if (seatBookedService.getSeatBookedByBookingIdAndSeatId(bookingId, seatId).isPresent()) {
            return ResponseEntity.ok().body(seatBookedService.getSeatBookedByBookingIdAndSeatId(bookingId, seatId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/seatBooked")
    public ResponseEntity<SeatBooked> addSeatBooked(@Valid @RequestBody SeatBooked seatBooked) {
        SeatBooked newSeatBooked = seatBookedService.addSeatBooked(seatBooked);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{bookingId}/{seatId}")
                .buildAndExpand(newSeatBooked.getBookingId(), newSeatBooked.getSeatId())
                .toUri();
        return ResponseEntity.created(location).body(newSeatBooked);
    }

    @DeleteMapping("/seatBooked/{bookingId}/{seatId}")
    @Transactional
    public ResponseEntity<?> deleteSeatBooked(@PathVariable int bookingId, @PathVariable int seatId) {
        if (seatBookedService.deleteSeatBooked(bookingId, seatId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
