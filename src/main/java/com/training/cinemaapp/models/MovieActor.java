package com.training.cinemaapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "movie_actor")
@Data
@IdClass(MovieActorId.class)
@NoArgsConstructor
public class MovieActor {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Id
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @ManyToOne(optional = false)
    @MapsId("movieId")
    private Movie movie;

    public MovieActor(String name, Integer movieId) {
        this.name = name;
        this.movieId = movieId;
    }


}
