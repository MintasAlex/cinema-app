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
    @ManyToOne(optional = false)
    @JoinColumn(name = "genre_name", nullable = false)
    private Genre genre;
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;


}
