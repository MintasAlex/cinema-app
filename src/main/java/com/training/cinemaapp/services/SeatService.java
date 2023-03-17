package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Seat;
import com.training.cinemaapp.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    public List<Seat> getSeatsByCinemaHallId(int cinemaHallId) {
        return seatRepository.findByCinemaHallId(cinemaHallId);
    }

    public Optional<Seat> getSeatById(int id) {
        return seatRepository.findById(id);
    }

    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Optional<Seat> updateSeat(Seat newSeat, int id) {
        return seatRepository.findById(id)
                .map(seat -> {
                    seat.setSeatName(newSeat.getSeatName());
                    seat.setCinemaHallId(newSeat.getCinemaHallId());
                    seatRepository.save(seat);
                    return seat;
                });
    }

    public Boolean deleteSeat(int id) {
        if (seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
