package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.SeatBooked;
import com.training.cinemaapp.models.SeatBookedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatBookedRepository extends JpaRepository<SeatBooked, SeatBookedId> {

    List<SeatBooked> findByBookingId(int bookingId);

    List<SeatBooked> findBySeatId(int seatId);

    Optional<SeatBooked> findByBookingIdAndSeatId(int bookingId, int seatId);

    boolean existsByBookingIdAndSeatId(int bookingId, int seatId);

    void deleteByBookingIdAndSeatId(int bookingId, int seatId);
}
