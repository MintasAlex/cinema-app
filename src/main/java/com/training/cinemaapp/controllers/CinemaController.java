package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Cinema;
import com.training.cinemaapp.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemas")
    public List<Cinema> getCinemas() {
        return cinemaService.getCinemas();
    }

    @GetMapping("/cinemas/{id}")
    public Cinema getCinemaById(@PathVariable int id) {
        return cinemaService.getCinemaById(id);
    }

    @PostMapping("/cinemas")
    public void addCinema(@RequestBody Cinema cinema) {
        cinemaService.addCinema(cinema);
    }
}
