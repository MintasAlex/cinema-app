package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Booking;
import com.training.cinemaapp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

    @GetMapping("/bookings/screening/{screeningId}")
    public List<Booking> getBookingsByScreeningId(@PathVariable int screeningId) {
        return bookingService.getBookingsByScreeningId(screeningId);
    }

    @GetMapping("/bookings/user/{userId}")
    public List<Booking> getBookingsByUserId(@PathVariable long userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable int id) {
        if (bookingService.getBookingById(id).isPresent()) {
            return ResponseEntity.ok().body(bookingService.getBookingById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
        Booking newBooking = bookingService.addBooking(booking);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newBooking.getId())
                .toUri();
        return ResponseEntity.created(location).body(newBooking);
    }

    @PutMapping("/bookings/{id}")
    public ResponseEntity<?> updateBooking(@Valid @RequestBody Booking newBooking, @PathVariable int id) {
        if (bookingService.updateBooking(newBooking, id).isPresent()) {
            return ResponseEntity.ok().body(bookingService.updateBooking(newBooking, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable int id) {
        if (bookingService.deleteBooking(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
