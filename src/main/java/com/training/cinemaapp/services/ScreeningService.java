package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Screening;
import com.training.cinemaapp.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;

    public List<Screening> getScreenings() {
        return screeningRepository.findAll();
    }

    public List<Screening> getScreeningByMovieId(int movieId) {
        return screeningRepository.findByMovieId(movieId);
    }

    public List<Screening> getScreeningByCinemaHallId(int cinemaHallId) {
        return screeningRepository.findByCinemaHallId(cinemaHallId);
    }

    public Optional<Screening> getScreeningById(int id) {
        return screeningRepository.findById(id);
    }

    public Screening addScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

    public Optional<Screening> updateScreening(Screening newScreening, int id) {
        return screeningRepository.findById(id)
                .map(screening -> {
                    screening.setMovieId(newScreening.getMovieId());
                    screening.setCinemaHallId(newScreening.getCinemaHallId());
                    screening.setStartTimestamp(newScreening.getStartTimestamp());
                    screeningRepository.save(screening);
                    return screening;
                });
    }

    public Boolean deleteScreening(int id) {
        if (screeningRepository.existsById(id)) {
            screeningRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}
