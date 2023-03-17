package com.training.cinemaapp.models;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Movie(String title, int runtimeMinutes, String score, String rating, String description) {
        this.title = title;
        this.runtimeMinutes = runtimeMinutes;
        this.score = score;
        this.rating = rating;
        this.description = description;
        this.picturePath = "";
    }

    public Movie(String title, int runtimeMinutes, String score, String rating, String description, String picturePath) {
        this.title = title;
        this.runtimeMinutes = runtimeMinutes;
        this.score = score;
        this.rating = rating;
        this.description = description;
        this.picturePath = picturePath;
    }
}
