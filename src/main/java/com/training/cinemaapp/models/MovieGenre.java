package com.training.cinemaapp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "movie_genre")
@Data
@NoArgsConstructor
@IdClass(MovieGenreId.class)
public class MovieGenre {

    @Id
    @Column(name = "genre_name", nullable = false)
    private String genreName;

    @Id
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @ManyToOne(optional = false)
    @MapsId("genreName")
    private Genre genre;

    @ManyToOne(optional = false)
    @MapsId("movieId")
    private Movie movie;

}
