package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findByUsername(String userName);
    Boolean existsByUsername(String userName);
    Boolean existsByEmail(String email);
}
