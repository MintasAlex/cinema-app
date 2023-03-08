package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.MovieGenre;
import com.training.cinemaapp.models.MovieGenreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieGenreRepository extends JpaRepository<MovieGenre, MovieGenreId> {
}
