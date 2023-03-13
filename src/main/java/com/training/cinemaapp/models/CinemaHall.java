package com.training.cinemaapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cinema_hall")
@Data
@NoArgsConstructor
public class CinemaHall {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "cinema_id")
    private int cinemaId;
    @Column(name = "capacity")
    private int capacity;

    public CinemaHall(String name, int cinemaId, int capacity) {
        this.name = name;
        this.cinemaId = cinemaId;
        this.capacity = capacity;
    }

}
