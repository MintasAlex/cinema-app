package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer> {
}
