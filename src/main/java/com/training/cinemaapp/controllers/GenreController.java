package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Genre;
import com.training.cinemaapp.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }
}
