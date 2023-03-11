package com.training.cinemaapp.controllers;

import com.training.cinemaapp.models.UserAccount;
import com.training.cinemaapp.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping("/users")
    public List<UserAccount> getUserAccounts() {
        return userAccountService.getUserAccounts();
    }

}
