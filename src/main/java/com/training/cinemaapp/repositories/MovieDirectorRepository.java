package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.MovieDirector;
import com.training.cinemaapp.models.MovieDirectorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDirectorRepository extends JpaRepository<MovieDirector, MovieDirectorId> {
}
