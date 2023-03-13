package com.training.cinemaapp.models;

import com.training.cinemaapp.models.UserAccount;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "refreshtoken")
@Data
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserAccount user;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;
}
