package com.training.cinemaapp.services;

import com.training.cinemaapp.models.UserAccount;
import com.training.cinemaapp.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> getUserAccounts() {
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> getUserAccountById(int id) {
        return userAccountRepository.findById(id);
    }

    public Optional<UserAccount> updateUserAccount(UserAccount newUserAccount, int id) {
        return userAccountRepository.findById(id)
                .map(userAccount -> {
                    userAccount.setUsername(newUserAccount.getUsername());
                    userAccount.setEmail(newUserAccount.getEmail());
                    userAccount.setPassword(newUserAccount.getPassword());
                    userAccount.setCreatedTimestamp(newUserAccount.getCreatedTimestamp());
                    userAccountRepository.save(userAccount);
                    return userAccount;
                });
    }

    public Boolean deleteUserAccount(int id) {
        if (userAccountRepository.existsById(id)) {
            userAccountRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
