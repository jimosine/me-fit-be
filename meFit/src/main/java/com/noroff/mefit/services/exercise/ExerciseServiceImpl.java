package com.noroff.mefit.services.exercise;

import com.noroff.mefit.models.Exercise;
import com.noroff.mefit.repositories.ExcerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private final ExcerciseRepository excerciseRepository;

    public ExerciseServiceImpl(ExcerciseRepository excerciseRepository) {
        this.excerciseRepository = excerciseRepository;
    }

    @Override
    public Exercise findById(Integer id) {
        return excerciseRepository.findById(id).get();
    }

    @Override
    public Collection<Exercise> findAll() {
        return excerciseRepository.findAll();
    }

    @Override
    public Exercise add(Exercise entity) {
        return excerciseRepository.save(entity);
    }

    @Override
    public Exercise update(Exercise entity) {
        return excerciseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        excerciseRepository.deleteById(id);
    }
}
