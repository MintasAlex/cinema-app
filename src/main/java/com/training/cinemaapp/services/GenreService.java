package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Genre;
import com.training.cinemaapp.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
