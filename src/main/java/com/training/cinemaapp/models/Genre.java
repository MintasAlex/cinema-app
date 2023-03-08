package com.training.cinemaapp.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "genre")
@Data
public class Genre {

    @Id
    @Column(name = "name")
    private String name;

    public Genre() {
    }
}
