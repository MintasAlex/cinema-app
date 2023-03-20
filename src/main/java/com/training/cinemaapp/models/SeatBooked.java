package com.training.cinemaapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "seat_booked")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SeatBookedId.class)
public class SeatBooked {

    @Id
    @Column(name = "booking_id", nullable = false)
    private Integer bookingId;

    @Id
    @Column(name = "seat_id", nullable = false)
    private Integer seatId;

    @Column(name = "screening_id", nullable = false)
    private Integer screeningId;

    @ManyToOne(optional = false)
    @MapsId("bookingId")
    private Booking booking;

    @ManyToOne(optional = false)
    @MapsId("seatId")
    private Seat seat;

    @ManyToOne(optional = false)
    @MapsId("screeningId")
    private Screening screening;


}
