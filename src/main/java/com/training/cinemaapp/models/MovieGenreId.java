package com.training.cinemaapp.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
public class MovieGenreId implements Serializable {
    private Genre genre;
    private Movie movie;
}
