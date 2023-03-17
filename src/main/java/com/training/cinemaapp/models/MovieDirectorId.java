package com.training.cinemaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieDirectorId implements Serializable {
    private String name;
    private Integer movieId;
}
