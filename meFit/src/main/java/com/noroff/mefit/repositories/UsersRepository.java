package com.noroff.mefit.repositories;

import com.noroff.mefit.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
