package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.UserRole;
import com.training.cinemaapp.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/userRoles")
    public List<UserRole> getUserRoles() {
        return userRoleService.getUserRoles();
    }
}
