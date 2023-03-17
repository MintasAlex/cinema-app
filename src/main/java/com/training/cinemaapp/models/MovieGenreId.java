package com.training.cinemaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieGenreId implements Serializable {
    private String genreName;
    private Integer movieId;
}
