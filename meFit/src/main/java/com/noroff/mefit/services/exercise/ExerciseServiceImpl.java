package com.noroff.mefit.services.exercise;

import com.noroff.mefit.models.Exercise;
import com.noroff.mefit.repositories.ExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Exercise findById(Integer id) {
        return exerciseRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Exercise not found"));
    }

    @Override
    public Collection<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise add(Exercise entity) {
        return exerciseRepository.save(entity);
    }

    @Override
    public Exercise update(Exercise entity) {
        return exerciseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        exerciseRepository.deleteById(id);
    }
}
