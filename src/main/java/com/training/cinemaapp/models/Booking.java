package com.training.cinemaapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "booking")
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "screening_id", nullable = false)
    private Integer screeningId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @MapsId("screeningId")
    private Screening screening;

    @ManyToOne
    @MapsId("userId")
    private UserAccount user;

    public Booking(Integer screeningId, Long userId) {
        this.screeningId = screeningId;
        this.userId = userId;
    }

}
