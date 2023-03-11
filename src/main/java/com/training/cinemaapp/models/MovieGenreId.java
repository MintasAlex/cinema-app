package com.training.cinemaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieGenreId implements Serializable {
    private Genre genre;
    private Movie movie;
}
