package com.training.cinemaapp.services;

import com.training.cinemaapp.models.SeatBooked;
import com.training.cinemaapp.repositories.SeatBookedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatBookedService {

    @Autowired
    private SeatBookedRepository seatBookedRepository;

    public List<SeatBooked> getSeatsBooked() {
        return seatBookedRepository.findAll();
    }

    public List<SeatBooked> getSeatsBookedByBookingId(int bookingId) {
        return seatBookedRepository.findByBookingId(bookingId);
    }

    public List<SeatBooked> getSeatsBookedBySeatId(int seatId) {
        return seatBookedRepository.findBySeatId(seatId);
    }

    public Optional<SeatBooked> getSeatBookedByBookingIdAndSeatId(int bookingId, int seatId) {
        return seatBookedRepository.findByBookingIdAndSeatId(bookingId, seatId);
    }

    public SeatBooked addSeatBooked(SeatBooked seatBooked) {
        return seatBookedRepository.save(seatBooked);
    }

    public Boolean deleteSeatBooked(int bookingId, int seatId) {
        if (seatBookedRepository.existsByBookingIdAndSeatId(bookingId, seatId)) {
            seatBookedRepository.deleteByBookingIdAndSeatId(bookingId, seatId);
            return true;
        } else {
            return false;
        }
    }


}
