package com.training.cinemaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieActorId implements Serializable {
    private String name;
    private Movie movie;
}
