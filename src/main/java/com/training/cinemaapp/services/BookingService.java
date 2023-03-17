package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Booking;
import com.training.cinemaapp.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByScreeningId(int screeningId) {
        return bookingRepository.findByScreeningId(screeningId);
    }

    public List<Booking> getBookingsByUserId(long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> updateBooking(Booking newBooking, int id) {
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setScreeningId(newBooking.getScreeningId());
                    booking.setUserId(newBooking.getUserId());
                    bookingRepository.save(booking);
                    return booking;
                });
    }

    public Boolean deleteBooking(int id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
