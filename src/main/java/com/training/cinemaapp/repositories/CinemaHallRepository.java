package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {
    Optional<CinemaHall> findById(Integer id);
}
