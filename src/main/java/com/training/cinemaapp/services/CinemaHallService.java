package com.training.cinemaapp.services;

import com.training.cinemaapp.models.CinemaHall;
import com.training.cinemaapp.repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaHallService {

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    public CinemaHall getCinemaHallById(Integer id) {
        return cinemaHallRepository.findById(id).orElseThrow(() -> new RuntimeException("Cinema hall not found"));
    }

    public void addCinemaHall(CinemaHall cinemaHall) {
        cinemaHallRepository.save(cinemaHall);
    }
}
