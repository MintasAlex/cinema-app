package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Booking;
import com.training.cinemaapp.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.training.cinemaapp.security.UserSecurity;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserSecurity userSecurity;

    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

    @GetMapping("/bookings/screening/{screeningId}")
    public List<Booking> getBookingsByScreeningId(@PathVariable int screeningId) {
        return bookingService.getBookingsByScreeningId(screeningId);
    }

    @GetMapping("/bookings/user/{userId}")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or @userSecurity.isUserBookingAuthor(authentication.principal.id, #userId)")
    public List<Booking> getBookingsByUserId(@PathVariable int userId) {
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
        //check if user is admin or is booking for himself
        if (userSecurity.isUserBookingForHimself(booking.getUserId())) {
            Booking newBooking = bookingService.addBooking(booking);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(newBooking.getId())
                    .toUri();
            return ResponseEntity.created(location).body(newBooking);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    @PutMapping("/bookings/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateBooking(@Valid @RequestBody Booking newBooking, @PathVariable int id) {
        if (bookingService.updateBooking(newBooking, id).isPresent()) {
            return ResponseEntity.ok().body(bookingService.updateBooking(newBooking, id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/bookings/{id}")
//    @PreAuthorize("hasRole('ROLE_ADMIN') or @userSecurity.isUserBookingAuthor(authentication.principal.id, #id)")
    public ResponseEntity<?> deleteBooking(@PathVariable int id) {
        if (userSecurity.isUserBookingAuthor(id)) {
            if (bookingService.deleteBooking(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

}


