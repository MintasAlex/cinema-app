package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.CinemaHall;
import com.training.cinemaapp.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @GetMapping("/cinema-halls")
    public List<CinemaHall> getCinemaHalls() {
        return cinemaHallService.getCinemaHalls();
    }

    @GetMapping("/cinema-halls/{id}")
    public CinemaHall getCinemaHallById(@PathVariable Integer id) {
        return cinemaHallService.getCinemaHallById(id);
    }

    @PostMapping("/cinema-halls")
    @PreAuthorize("hasRole('ADMIN')")
    public String addCinemaHall(@RequestBody CinemaHall cinemaHall) {
        cinemaHallService.addCinemaHall(cinemaHall);
        return "Cinema hall added successfully";
    }


}
