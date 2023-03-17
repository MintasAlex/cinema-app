package com.training.cinemaapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "seat")
@Data
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seat_name", nullable = false)
    private String seatName;

    @Column(name = "cinema_hall_id", nullable = false)
    private Integer cinemaHallId;

    @ManyToOne(optional = false)
    @MapsId("cinemaHallId")
    private CinemaHall cinemaHall;

    public Seat(String seatName, Integer cinemaHallId) {
        this.seatName = seatName;
        this.cinemaHallId = cinemaHallId;
    }
}
