package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.MovieActor;
import com.training.cinemaapp.models.MovieActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, MovieActorId> {
}
