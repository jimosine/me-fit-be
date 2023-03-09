package com.noroff.mefit.repositories;

import com.noroff.mefit.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {
}
