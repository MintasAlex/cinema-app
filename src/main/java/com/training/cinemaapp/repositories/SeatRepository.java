package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findByCinemaHallId(int cinemaHallId);
}
