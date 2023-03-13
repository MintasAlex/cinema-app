package com.training.cinemaapp.repositories;

import com.training.cinemaapp.models.UserRole;
import com.training.cinemaapp.models.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
}
