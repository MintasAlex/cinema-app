package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.UserAccount;
import com.training.cinemaapp.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserAccount> getUserAccounts() {
        return userAccountService.getUserAccounts();
    }

    @GetMapping("/users/{id}")
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isCurrentUser(#id)")
    public UserAccount getUserAccountById(@PathVariable int id) {
        return userAccountService.getUserAccountById(id);
    }

}
