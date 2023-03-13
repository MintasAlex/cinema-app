package com.training.cinemaapp.services;

import com.training.cinemaapp.models.UserAccount;
import com.training.cinemaapp.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> getUserAccounts() {
        return userAccountRepository.findAll();
    }


}
