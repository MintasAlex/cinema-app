package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Integer> {

    List<Screening> findByMovieId(int movieId);

    List<Screening> findByCinemaHallId(int cinemaHallId);

    Optional<Screening> findById(int id);

}
