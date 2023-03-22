package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByScreeningId(int screeningId);

    List<Booking> findByUserId(int userId);
}
