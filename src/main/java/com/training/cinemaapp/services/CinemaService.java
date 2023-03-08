package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Cinema;
import com.training.cinemaapp.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getCinemas() {
        return cinemaRepository.findAll();
    }

    public Cinema getCinemaById(int id) {
        return cinemaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cinema not found"));
    }

    public void addCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }


}
