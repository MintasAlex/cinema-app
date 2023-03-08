package com.training.cinemaapp.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "movie")
@Data
public class Movie {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "runtime_minutes")
    private int runtimeMinutes;
    @Column(name = "score")
    private String score;
    @Column(name = "rating")
    private String rating;
    @Column(name = "description")
    private String description;
    @Column(name = "picture_path")
    private String picturePath;

    public Movie() {
    }
}
