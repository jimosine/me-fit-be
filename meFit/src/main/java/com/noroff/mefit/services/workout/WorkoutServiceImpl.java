package com.noroff.mefit.services.workout;

import com.noroff.mefit.models.Exercise;
import com.noroff.mefit.models.Workout;
import com.noroff.mefit.repositories.ExerciseRepository;
import com.noroff.mefit.repositories.WorkoutRepository;
import com.noroff.mefit.services.exercise.ExerciseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    private final WorkoutRepository workoutRepository;
    @Autowired
    private final ExerciseRepository exerciseRepository;

    @Autowired
    private final ExerciseService exerciseService;

//    @Autowired
//    private final Logger loginfo;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, ExerciseRepository exerciseRepository, ExerciseService exerciseService) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
        this.exerciseService = exerciseService;
    }

    @Override
    public Workout findById(Integer id) {
        return workoutRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Workout not found"));
    }

    @Override
    public Collection<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout add(Workout entity) {
        return workoutRepository.save(entity);
    }

    @Override
    public Workout update(Workout entity) {
        return workoutRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        workoutRepository.deleteById(id);
    }

    @Override
    public void addExercises(int workoutId, List<Integer> exerciseIds) {
        Workout workout = workoutRepository.findById(workoutId).orElseThrow(()-> new EntityNotFoundException("could not find workout"));
        Set<Exercise> newExercises= new HashSet<>();
        for (Integer exerciseId: exerciseIds){
            Exercise exercise =exerciseService.findById(exerciseId);
            newExercises.add(exercise);
        }
        workout.setExercises(newExercises);
        workoutRepository.save(workout);
    }
}
