package com.training.cinemaapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "cinema_hall")
@Data
@AllArgsConstructor
public class CinemaHall {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "cinema_id")
    private int cinemaId;
    @Column(name = "capacity")
    private int capacity;

    public CinemaHall() {
    }


}
