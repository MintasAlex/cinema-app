package com.training.cinemaapp.payload.request;

import lombok.Data;

import java.util.Set;

import javax.validation.constraints.*;

@Data
public class SignupRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    private String password;

}

