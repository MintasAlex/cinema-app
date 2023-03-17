package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Cinema;
import com.training.cinemaapp.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getCinemas() {
        return cinemaRepository.findAll();
    }

    public Optional<Cinema> getCinemaById(int id) {
        return cinemaRepository.findById(id);
    }

    public Cinema addCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Optional<Cinema> updateCinema(Cinema newCinema, int id) {
        return cinemaRepository.findById(id)
                .map(cinema -> {
                    cinema.setName(newCinema.getName());
                    cinema.setAddress(newCinema.getAddress());
                    cinemaRepository.save(cinema);
                    return cinema;
                });
    }

    public Boolean deleteCinema(int id) {
        if (cinemaRepository.existsById(id)) {
            cinemaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
