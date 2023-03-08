package com.training.cinemaapp.models;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "movie_actor")
@Data
@IdClass(MovieActorId.class)
public class MovieActor {
    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public MovieActor() {
    }

}
