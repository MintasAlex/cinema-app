package com.training.cinemaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeatBookedId implements Serializable {
    private Integer bookingId;
    private Integer seatId;
}

