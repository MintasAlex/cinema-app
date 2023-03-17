package com.training.cinemaapp.services;

import com.training.cinemaapp.models.Role;
import com.training.cinemaapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
    }
}
