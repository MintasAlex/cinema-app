package com.training.cinemaapp.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleId implements Serializable {
    private Long userId;
    private Integer roleId;
}
