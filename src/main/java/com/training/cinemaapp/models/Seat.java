package com.training.cinemaapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "seat")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
