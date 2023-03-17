package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.Role;
import com.training.cinemaapp.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/roles/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }
}
