package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.UserRole;
import com.training.cinemaapp.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/user-roles")
    public List<UserRole> getUserRoles() {
        return userRoleService.getUserRoles();
    }

    @GetMapping("/user-roles/{id}")
    public List<UserRole> getUserRolesByUserId(@PathVariable Long id) {
        return userRoleService.getUserRolesByUserId(id);
    }

    @GetMapping("/user-roles/{userId}/{roleId}")
    public ResponseEntity<?> getUserRoleByUserIdAndRoleId(@PathVariable Long userId, @PathVariable int roleId) {
        if (userRoleService.getUserRoleByUserIdAndRoleId(userId, roleId).isPresent()) {
            return ResponseEntity.ok().body(userRoleService.getUserRoleByUserIdAndRoleId(userId, roleId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user-roles")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserRole> addUserRole(@Valid @RequestBody UserRole userRole) {
        UserRole newUserRole = userRoleService.addUserRole(userRole);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}/{roleId}")
                .buildAndExpand(newUserRole.getUserId(), newUserRole.getRoleId())
                .toUri();
        return ResponseEntity.created(location).body(newUserRole);
    }

    @DeleteMapping("/user-roles/{userId}/{roleId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public ResponseEntity<?> deleteUserRole(@PathVariable Long userId, @PathVariable int roleId) {
        if (userRoleService.deleteUserRole(userId, roleId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
