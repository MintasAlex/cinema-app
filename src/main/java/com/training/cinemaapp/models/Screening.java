package com.training.cinemaapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "screening")
@Data
@NoArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_timestamp", nullable = false)
    private Timestamp startTimestamp;

    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "cinema_hall_id", nullable = false)
    private Integer cinemaHallId;

    @ManyToOne(optional = false)
    @MapsId("movieId")
    private Movie movie;

    @ManyToOne(optional = false)
    @MapsId("cinemaHallId")
    private CinemaHall cinemaHall;

    public Screening(Integer movieId, Integer cinemaHallId, Timestamp startTimestamp) {
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.startTimestamp = startTimestamp;
    }
}
