package com.training.cinemaapp.services;

import com.training.cinemaapp.models.CinemaHall;
import com.training.cinemaapp.repositories.CinemaHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaHallService {

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    public Optional<CinemaHall> getCinemaHallById(Integer id) {
        return cinemaHallRepository.findById(id);
    }

    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }

    public Optional<CinemaHall> updateCinemaHall(CinemaHall newCinemaHall, Integer id) {
        return cinemaHallRepository.findById(id)
                .map(cinemaHall -> {
                    cinemaHall.setName(newCinemaHall.getName());
                    cinemaHall.setCapacity(newCinemaHall.getCapacity());
                    cinemaHallRepository.save(cinemaHall);
                    return cinemaHall;
                });
    }

    public Boolean deleteCinemaHall(Integer id) {
        if (cinemaHallRepository.existsById(id)) {
            cinemaHallRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
