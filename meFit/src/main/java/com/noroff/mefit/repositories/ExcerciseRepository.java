package com.noroff.mefit.repositories;

import com.noroff.mefit.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcerciseRepository extends JpaRepository<Exercise, Integer> {
}