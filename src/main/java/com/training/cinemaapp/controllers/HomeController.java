package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Cinema;
import com.training.cinemaapp.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }


}

