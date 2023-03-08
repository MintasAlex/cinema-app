package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.CinemaHall;
import com.training.cinemaapp.services.CinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @GetMapping("/cinema-halls")
    public List<CinemaHall> getCinemaHalls() {
        return cinemaHallService.getCinemaHalls();
    }


}
